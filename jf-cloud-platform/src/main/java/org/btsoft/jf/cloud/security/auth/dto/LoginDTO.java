package org.btsoft.jf.cloud.security.auth.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 登录DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:04
 */
public class LoginDTO implements Serializable {

	private static final long serialVersionUID = -3464221616175516587L;

	@NotBlank
	private String userAccount;

	@NotBlank
	private String password;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
