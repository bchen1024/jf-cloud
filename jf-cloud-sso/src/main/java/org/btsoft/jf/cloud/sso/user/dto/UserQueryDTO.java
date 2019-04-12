package org.btsoft.jf.cloud.sso.user.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 用户查询DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:24
 */
public class UserQueryDTO extends PageDTO {

	private static final long serialVersionUID = 525260779941400653L;

	private String userAccount;

	private String userName;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
