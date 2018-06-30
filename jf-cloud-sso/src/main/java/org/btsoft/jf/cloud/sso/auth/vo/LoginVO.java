package org.btsoft.jf.cloud.sso.auth.vo;

import java.io.Serializable;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午9:51:50
 */
public class LoginVO implements Serializable {

	private static final long serialVersionUID = -8860339639735032411L;

	private UserInfo user;
	
	private String token;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
