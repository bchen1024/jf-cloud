package org.btsoft.jf.cloud.sso.token.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * token查询DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:31
 */
public class TokenQueryDTO extends PageDTO {

	private static final long serialVersionUID = -8936833193714977595L;

	/**
	 * 用户账号
	 */
	private String userAccount;

	/**
	 * 令牌
	 */
	private String token;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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
