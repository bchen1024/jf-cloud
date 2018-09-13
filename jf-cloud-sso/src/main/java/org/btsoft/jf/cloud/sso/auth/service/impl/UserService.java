package org.btsoft.jf.cloud.sso.auth.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.sso.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.sso.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.sso.auth.entity.User;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;
import org.btsoft.jf.cloud.sso.auth.mapper.IUserMapper;
import org.btsoft.jf.cloud.sso.auth.mapper.IUserTokenMapper;
import org.btsoft.jf.cloud.sso.auth.service.IUserService;
import org.btsoft.jf.cloud.sso.auth.vo.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:42:02
 */
@Service
public class UserService implements IUserService {
	
	/**
	 * 允许密码错误次数，默认5次
	 */
	@Value("${jf.cloud.sso.passwordErrorNumber:5}")
	private int passwordErrorNumber;
	
	/**
	 * 用户锁定时长,默认5分钟
	 */
	@Value("${jf.cloud.sso.lockDuration:300000}")
	private int lockDuration;
	
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
	private IUserTokenMapper userTokenMapper;
	
	@Override
	public User findUserByAccount(String userAccount) {
		//根据帐号获取用户
		User user=new User();
		user.setUserAccount(userAccount);
		user= mapper.findUserByAccount(user);
		
		if(user==null){//帐号不存在
			throw new ApplicationException("sso.auth.user.notExists","The user does not exist");
		}else if(!"Y".equals(user.getUserStatus())){//用户是无效的
			throw new ApplicationException("sso.auth.user.invalid","The user is invalid");
		}else if(user.getLockTime()!=null){//用户密码错误被锁定中
			long lockTime=user.getLockTime().getTime();
			long curTime=System.currentTimeMillis();
			if(curTime-lockTime<=lockDuration && lockDuration>0){//用户属于锁定中，无法登录
				throw new ApplicationException("sso.auth.user.lock",
						String.format("The user is locked for %s seconds",(lockDuration+lockTime-curTime)/1000),new Object[]{(lockDuration+lockTime-curTime)/1000});
			}else{//用户已超过锁定时长，解除锁定
				this.updateUserPwdErrorAndLockTime(0, null);
			}
		}
		return user;
	}
	
	@Override
	public LoginVO login(LoginDTO login) {
		User user=this.findUserByAccount(login.getUserAccount());
		//密码不匹配
		String desPassword=DESEncrypt.encrypt(login.getPassword());
		if(!desPassword.equals(user.getPassword())){
			int errorCount=user.getPwdError()+1;
			if(errorCount>passwordErrorNumber){//密码错误次数超过限制，锁定用户
				this.updateUserPwdErrorAndLockTime(errorCount, new Date());
				throw new ApplicationException("sso.auth.login.lockUser",
						String.format("The number of password errors is more than %s times, and the user is locked", errorCount),
						new Object[]{errorCount,passwordErrorNumber});
			}else{//密码错误，更新密码错误次数
				this.updateUserPwdErrorAndLockTime(errorCount, null);
				throw new ApplicationException("sso.auth.login.password.error",
						String.format("The password has been wrong %s times, and the wrong %s time will lock the user", errorCount,passwordErrorNumber-errorCount),
						new Object[]{errorCount,passwordErrorNumber});
			}
			
		}else if(user.getLockTime()!=null || user.getPwdError()>0){
			//密码正确,如果被锁定或者密码错误多次，解锁用户并且更新用户密码错误次数为0
			this.updateUserPwdErrorAndLockTime(0, null);
		}
		//生成token
		LoginVO loginVO=new LoginVO();
		String token=DESEncrypt.createJWT(user.getUserAccount(), expirationTime, signingKey);
		loginVO.setToken(token);
		UserInfo userInfo=new UserInfo();
		BeanUtils.copyProperties(user, userInfo);
		loginVO.setUser(userInfo);
		
		//保存用户token记录
		UserToken userToken=new UserToken();
		userToken.setUserAccount(user.getUserAccount());
		userToken.setToken(token);
		userToken.setTokenType("PC");
		userTokenMapper.createUserToken(userToken);
		return loginVO;
	}

	@Override
	public int updatePassword(UpdatePasswordDTO dto) {
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
		user.setPassword(DESEncrypt.encrypt(dto.getNewPassword()));
		return mapper.updatePassword(user);
	}
	
	private void updateUserPwdErrorAndLockTime(int pwdError,Date lockTime){
		User user=new User();
		user.setPwdError(pwdError);
		user.setLockTime(lockTime);
		mapper.updateUserPwdErrorAndLockTime(user);
	}

	@Override
	public List<User> findUserListById(List<Long> userIdList) {
		if(CollectionUtils.isEmpty(userIdList)) {
			return Collections.emptyList();
		}
		//去重
		Set<Long> userIdSet=new HashSet<Long>();
		userIdSet.addAll(userIdList);
		
		userIdList=new ArrayList<Long>();
		userIdList.addAll(userIdSet);
		return mapper.findUserListById(userIdList);
	}

	@Override
	public Map<Long, UserInfo> findUserMapById(List<Long> userIdList) {
		List<User> userList=this.findUserListById(userIdList);
		Map<Long, UserInfo> result=new HashMap<Long, UserInfo>();
		if(!CollectionUtils.isEmpty(userList)) {
			userList.forEach(user->{
				UserInfo userInfo=new UserInfo();
				BeanUtils.copyProperties(user, userInfo);
				result.put(user.getUserId(), userInfo);
			});
		}
		return result;
	}

}
