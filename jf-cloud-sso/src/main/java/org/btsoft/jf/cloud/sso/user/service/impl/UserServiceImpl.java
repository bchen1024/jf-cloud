package org.btsoft.jf.cloud.sso.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.sso.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.sso.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.sso.auth.vo.LoginVO;
import org.btsoft.jf.cloud.sso.token.entity.Token;
import org.btsoft.jf.cloud.sso.token.mapper.ITokenMapper;
import org.btsoft.jf.cloud.sso.user.dto.UserAddDTO;
import org.btsoft.jf.cloud.sso.user.dto.UserQueryDTO;
import org.btsoft.jf.cloud.sso.user.entity.User;
import org.btsoft.jf.cloud.sso.user.mapper.IUserMapper;
import org.btsoft.jf.cloud.sso.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:42:02
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private SsoAuthProperties ssoAuthProperties;
	
	/**
	 * jwt密钥
	 */
	@Value("${jf.cloud.sso.signingKey:null}")
	private String signingKey;
	
	/**
	 * jwt过期时长
	 */
	@Value("${jf.cloud.sso.expirationTime:0}")
	private long expirationTime;

	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private ITokenMapper userTokenMapper;
	
	@Override
	public CommonResult<LoginVO> login(LoginDTO login) {
		User user=this.findUserByAccount(login.getUserAccount());
		//密码不匹配
		String desPassword=DESEncrypt.encrypt(login.getPassword());
		if(!desPassword.equals(user.getPassword())){
			int errorCount=user.getPwdError()+1;
			int passwordErrorNumber=ssoAuthProperties.getAllowPasswordErrorNum();
			//密码错误次数超过限制，锁定用户
			if(errorCount>passwordErrorNumber){
				this.updateUserPwdErrorAndLockTime(errorCount, new Date(),user.getUserId());
				throw new ApplicationException("sso.auth.login.lockUser",
						String.format("The number of password errors is more than %s times, and the user is locked", errorCount),
						new Object[]{errorCount,passwordErrorNumber});
			}else{//密码错误，更新密码错误次数
				this.updateUserPwdErrorAndLockTime(errorCount, null,user.getUserId());
				throw new ApplicationException("sso.auth.login.password.error",
						String.format("The password has been wrong %s times, and the wrong %s time will lock the user", errorCount,passwordErrorNumber-errorCount),
						new Object[]{errorCount,passwordErrorNumber});
			}
			
		}else if(user.getLockTime()!=null || user.getPwdError()>0){
			//密码正确,如果被锁定或者密码错误多次，解锁用户并且更新用户密码错误次数为0
			this.updateUserPwdErrorAndLockTime(0, null,user.getUserId());
		}
		//生成token
		LoginVO loginVO=new LoginVO();
		String token=DESEncrypt.createJWT(user.getUserAccount(), expirationTime, signingKey);
		loginVO.setToken(token);
		UserInfo userInfo=new UserInfo();
		BeanUtils.copyProperties(user, userInfo);
		loginVO.setUser(userInfo);
		
		//保存用户token记录
		Token userToken=new Token();
		userToken.setUserAccount(user.getUserAccount());
		userToken.setToken(token);
		userToken.setTokenType("PC");
		userTokenMapper.createSingle(userToken);
		return CommonResultUtils.success(loginVO);
	}

	@Override
	public CommonResult<Integer> updatePassword(UpdatePasswordDTO dto) {
		//新密码和确认密码不一致
		if(dto.getNewPassword()!=null && !dto.getNewPassword().equals(dto.getConfirmPassword())){
			throw new ApplicationException("login.auth.password.nosame","Your confirmed password and new password do not match");
		}
		User user=this.findUserByAccount(dto.getUserAccount());
		
		//原始密码不正确
		String originalPassword=DESEncrypt.encrypt(dto.getOriginalPassword());
		if(!user.getPassword().equals(originalPassword)){
			throw new ApplicationException("login.auth.password.error","Original password error");
		}
		User updateUser=new User();
		updateUser.setUserId(user.getUserId());
		updateUser.setPassword(DESEncrypt.encrypt(dto.getNewPassword()));
		int row=mapper.patchSingle(user);
		return CommonResultUtils.success(row);
	}
	
	@Override
	public CommonResult<List<UserInfo>> findUserListByUserId(List<Long> userIdList) {
		List<UserInfo> list=new ArrayList<UserInfo>();
		if(CollectionUtils.isEmpty(userIdList)) {
			return CommonResultUtils.success(list);
		}
		//去重
		Set<Long> userIdSet=new HashSet<Long>();
		userIdSet.addAll(userIdList);
		
		userIdList=new ArrayList<Long>();
		userIdList.addAll(userIdSet);
		List<User> userList=mapper.findUserListByUserId(userIdList);
		list=EntityUtils.dtoToEntityList(userList, UserInfo.class);
		return CommonResultUtils.success(list);
	}

	@Override
	public CommonResult<Map<Long, UserInfo>> findUserMapByUserId(List<Long> userIdList) {
		List<User> userList=mapper.findUserListByUserId(userIdList);
		Map<Long, UserInfo> result=new HashMap<Long, UserInfo>(userList.size());
		if(!CollectionUtils.isEmpty(userList)) {
			userList.forEach(user->{
				UserInfo userInfo=new UserInfo();
				BeanUtils.copyProperties(user, userInfo);
				result.put(user.getUserId(), userInfo);
			});
		}
		return CommonResultUtils.success(result);
	}

	@Override
	public CommonResult<PageResult<UserInfo>> findPageList(UserQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		User user=EntityUtils.copyProperties(dto, User.class);
		List<User> result = mapper.findList(user);
		List<UserInfo> userList=EntityUtils.dtoToEntityList(result, UserInfo.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(userList, dto.getCurPage(), dto.getPageSize()));
	}
	
	@Override
	public User findUserByAccount(String userAccount) {
		//根据帐号获取用户
		User user=new User();
		user.setUserAccount(userAccount);
		user= mapper.findSingle(user);
		
		//帐号不存在
		if(user==null){
			throw new ApplicationException("sso.auth.user.notExists","The user does not exist");
		}else if(!"Y".equals(user.getUserStatus())){
			//用户是无效的
			throw new ApplicationException("sso.auth.user.invalid","The user is invalid");
		}else if(user.getLockTime()!=null){
			//用户密码错误被锁定中
			long lockTime=user.getLockTime().getTime();
			long curTime=System.currentTimeMillis();
			long lockDuration=ssoAuthProperties.getLockDuration();
			if(curTime-lockTime<=lockDuration && lockDuration>0){
				//用户属于锁定中，无法登录
				throw new ApplicationException("sso.auth.user.lock",
						String.format("The user is locked for %s seconds",(lockDuration+lockTime-curTime)/1000),new Object[]{(lockDuration+lockTime-curTime)/1000});
			}else{//用户已超过锁定时长，解除锁定
				this.updateUserPwdErrorAndLockTime(0, null,user.getUserId());
			}
		}
		return user;
	}
	
	private void updateUserPwdErrorAndLockTime(int pwdError,Date lockTime,Long userId){
		User user=new User();
		user.setPwdError(pwdError);
		user.setLockTime(lockTime);
		user.setUserId(userId);
		mapper.patchSingle(user);
	}

	@Override
	public CommonResult<UserInfo> createSingle(UserAddDTO dto) {
		//校验account是否重复
		String userAccount=dto.getUserAccount();
		if(StringUtils.isEmpty(userAccount)) {
			//如果账号为空，自动生成account
			userAccount="";
		}
		return null;
	}

}
