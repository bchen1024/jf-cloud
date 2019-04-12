package org.btsoft.jf.cloud.security.auth.service.impl;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.security.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.security.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.security.auth.service.IAuthService;
import org.btsoft.jf.cloud.security.auth.vo.LoginVO;
import org.btsoft.jf.cloud.security.token.entity.Token;
import org.btsoft.jf.cloud.security.token.mapper.ITokenMapper;
import org.btsoft.jf.cloud.security.user.entity.User;
import org.btsoft.jf.cloud.security.user.mapper.IUserMapper;
import org.btsoft.jf.cloud.security.user.service.IUserService;
import org.btsoft.jf.cloud.security.user.service.impl.SsoAuthProperties;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenbin
 * @date 2019-04-10 22:37
 */
@Service
public class AuthServiceImpl implements IAuthService {
	
	@Autowired
	private SsoAuthProperties ssoAuthProperties;
	
	@Autowired
	private IUserMapper userMapper;
	
	@Autowired
	private ITokenMapper userTokenMapper;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public CommonResult<LoginVO> login(LoginDTO login) {
		User user=userService.findUserByAccount(login.getUserAccount());
		//密码不匹配
		String desPassword=DESEncrypt.encrypt(login.getPassword());
		if(!desPassword.equals(user.getPassword())){
			int errorCount=user.getPwdError()+1;
			int passwordErrorNumber=ssoAuthProperties.getAllowPasswordErrorNum();
			//密码错误次数超过限制，锁定用户
			if(errorCount>=passwordErrorNumber){
				User updateUser=new User();
				updateUser.setUserId(user.getUserId());
				updateUser.setPwdError(errorCount);
				updateUser.setUserStatus("L");
				userMapper.patchSingle(updateUser);
				return CommonResultUtils.fail("sso.auth.login.lockUser", 
						String.format("The number of password errors is more than %s times, and the user is locked", errorCount), 
						new Object[]{errorCount,passwordErrorNumber});
			}else{//密码错误，更新密码错误次数
				User updateUser=new User();
				updateUser.setPwdError(errorCount);
				updateUser.setUserId(user.getUserId());
				userMapper.patchSingle(updateUser);
				return CommonResultUtils.fail("sso.auth.login.password.error", 
						String.format("The password has been wrong %s times, and the wrong %s time will lock the user", errorCount,passwordErrorNumber-errorCount),
						new Object[]{errorCount,passwordErrorNumber});
			}
			
		}else if(user.getLockTime()!=null || user.getPwdError()>0){
			//密码正确,如果被锁定或者密码错误多次，解锁用户并且更新用户密码错误次数为0
			User updateUser=new User();
			updateUser.setUserId(user.getUserId());
			updateUser.setPwdError(0);
			updateUser.setUserStatus("Y");
			userMapper.patchSingle(updateUser);
		}
		//生成token
		LoginVO loginVO=new LoginVO();
		String token=DESEncrypt.createJWT(user.getUserAccount(), ssoAuthProperties.getExpirationTime(), ssoAuthProperties.getSigningKey());
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
		User user=userService.findUserByAccount(dto.getUserAccount());
		
		//原始密码不正确
		String originalPassword=DESEncrypt.encrypt(dto.getOriginalPassword());
		if(!user.getPassword().equals(originalPassword)){
			throw new ApplicationException("login.auth.password.error","Original password error");
		}
		User updateUser=new User();
		updateUser.setUserId(user.getUserId());
		updateUser.setPassword(DESEncrypt.encrypt(dto.getNewPassword()));
		int row=userMapper.updatePassword(user);
		return CommonResultUtils.success(row);
	}

}
