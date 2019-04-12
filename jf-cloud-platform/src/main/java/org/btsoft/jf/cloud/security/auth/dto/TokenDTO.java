package org.btsoft.jf.cloud.security.auth.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午12:10:11
 */
public class TokenDTO implements Serializable {

	private static final long serialVersionUID = 3638466014235060884L;

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
