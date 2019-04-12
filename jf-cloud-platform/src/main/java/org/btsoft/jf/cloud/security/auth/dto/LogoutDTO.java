package org.btsoft.jf.cloud.security.auth.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 登出DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:07
 */
public class LogoutDTO implements Serializable {

	private static final long serialVersionUID = 1544346377276474905L;

	@NotBlank
	private String token;

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
