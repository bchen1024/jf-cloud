package org.btsoft.jf.cloud.security.auth.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;

/**
 * 登录VO
 * 
 * @author chenbin
 * @date 2018-11-27 23:10
 */
public class LoginVO implements Serializable {

	private static final long serialVersionUID = -388341936334362129L;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
