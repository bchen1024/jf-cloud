package org.btsoft.jf.cloud.sso.auth.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午9:53:44
 */
public class LoginDTO implements Serializable{

	private static final long serialVersionUID = -7853826842213268882L;

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
	
}
