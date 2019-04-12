package org.btsoft.jf.cloud.sso.token.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @desc 用户Token VO对象
 * @author chenbin
 * @date 2018年10月18日 下午11:49:24
 */
public class TokenVO implements Serializable {

	private static final long serialVersionUID = -5908267830427490489L;

	/**
	 * 用户账号
	 */
	private String userAccount;

	/**
	 * 令牌
	 */
	private String token;

	/**
	 * 令牌类型
	 */
	private String tokenType;

	private Date creationDate;

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

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
