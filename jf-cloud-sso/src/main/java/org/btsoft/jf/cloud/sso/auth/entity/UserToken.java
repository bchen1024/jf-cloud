package org.btsoft.jf.cloud.sso.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chenbin
 * @date 2018年6月30日 下午11:42:06
 */
public class UserToken implements Serializable {

	private static final long serialVersionUID = -2075382729941151697L;
	
	private String userAccount;
	
	private String token;
	
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

}
