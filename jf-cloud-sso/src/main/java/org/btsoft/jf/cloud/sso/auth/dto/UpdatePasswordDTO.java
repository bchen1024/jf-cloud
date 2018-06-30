package org.btsoft.jf.cloud.sso.auth.dto;

import java.io.Serializable;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午11:41:17
 */
public class UpdatePasswordDTO implements Serializable {

	private static final long serialVersionUID = -4464203512002010698L;
	
	private String userAccount;
	
	private String originalPassword;
	
	private String newPassword;
	
	private String confirmPassword;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getOriginalPassword() {
		return originalPassword;
	}

	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}