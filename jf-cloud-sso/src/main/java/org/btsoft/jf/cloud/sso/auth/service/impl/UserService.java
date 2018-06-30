package org.btsoft.jf.cloud.sso.auth.service.impl;

import java.util.Date;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.sso.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.sso.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.sso.auth.entity.User;
import org.btsoft.jf.cloud.sso.auth.mapper.IUserMapper;
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

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public User findUserByAccount(String userAccount) {
		//根据帐号获取用户
		User user=new User();
		user.setUserAccount(userAccount);
		user= mapper.findUserByAccount(user);
		
		if(user==null){//帐号不存在
			throw new ApplicationException("login.auth.user.notExists","The user does not exist");
		}else if(!"Y".equals(user.getUserStatus())){//用户是无效的
			throw new ApplicationException("login.auth.user.invalid","The user is invalid");
		}else if(user.getLockTime()!=null){//用户密码错误被锁定中
			long lockTime=user.getLockTime().getTime();
			long curTime=System.currentTimeMillis();
			if(curTime-lockTime<=lockDuration){
				throw new ApplicationException("login.auth.user.lock",
						String.format("The user is locked for %s seconds",(lockDuration+lockTime-curTime)/1000),new Object[]{(lockDuration+lockTime-curTime)/1000});
			}else{
				user.setPwdError(0);
				user.setLockTime(null);
				mapper.updateUserPwdErrorAndLockTime(user);
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
			user.setPwdError(errorCount);
			if(errorCount>passwordErrorNumber){
				user.setLockTime(new Date());
				mapper.updateUserPwdErrorAndLockTime(user);
				throw new ApplicationException("login.auth.password.incorrect","Incorrect password",new Object[]{errorCount,passwordErrorNumber});
			}
			//更新密码错误次数
			user.setLockTime(null);
			mapper.updateUserPwdErrorAndLockTime(user);
			throw new ApplicationException("login.auth.password.incorrect",
					String.format("Incorrect password,Error %s times,The wrong %s time will lock the user", errorCount,passwordErrorNumber-user.getPwdError()),new Object[]{errorCount,passwordErrorNumber});
		}else{
			user.setPwdError(0);
			user.setLockTime(null);
			mapper.updateUserPwdErrorAndLockTime(user);
		}
		//生成token
		LoginVO loginVO=new LoginVO();
		String token=DESEncrypt.createJWT(user.getUserAccount(), 0L, null);
		loginVO.setToken(token);
		
		UserInfo userInfo=new UserInfo();
		BeanUtils.copyProperties(user, userInfo);
		loginVO.setUser(userInfo);
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

}
