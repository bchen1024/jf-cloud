package org.btsoft.jf.cloud.sso.auth.dto;

import java.io.Serializable;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午12:06:00
 */
public class LogoutDTO implements Serializable {

	private static final long serialVersionUID = 1544346377276474905L;

	private String token;

	private String userAccount;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

}
