package org.btsoft.jf.cloud.sso.user.entity;

import java.util.Date;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:29:18
 */
public class User extends UserInfo {

	private static final long serialVersionUID = 6747375324119470846L;
	
	private String password;
	
	private Date pwdUpdateTime;
	
	private Integer pwdError;
	
	private Date lockTime;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPwdUpdateTime() {
		return pwdUpdateTime;
	}

	public void setPwdUpdateTime(Date pwdUpdateTime) {
		this.pwdUpdateTime = pwdUpdateTime;
	}

	public Integer getPwdError() {
		return pwdError;
	}

	public void setPwdError(Integer pwdError) {
		this.pwdError = pwdError;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

}
