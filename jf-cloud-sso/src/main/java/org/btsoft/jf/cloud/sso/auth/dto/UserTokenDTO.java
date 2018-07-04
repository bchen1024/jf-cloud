package org.btsoft.jf.cloud.sso.auth.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午12:10:11
 */
public class UserTokenDTO implements Serializable {

	private static final long serialVersionUID = 3638466014235060884L;
	 
	@NotBlank
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
