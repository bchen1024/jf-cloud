package org.btsoft.jf.cloud.security.auth.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 密码更新DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:09
 */
public class UpdatePasswordDTO implements Serializable {

	private static final long serialVersionUID = -4464203512002010698L;

	@NotBlank
	private String userAccount;

	@NotBlank
	private String originalPassword;

	@NotBlank
	private String newPassword;

	@NotBlank
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
