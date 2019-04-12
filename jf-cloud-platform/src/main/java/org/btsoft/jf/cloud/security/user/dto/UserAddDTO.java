package org.btsoft.jf.cloud.security.user.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户添加DTO
 * 
 * @author chenbin
 * @date 2018-11-27 23:12
 */
public class UserAddDTO extends BaseDTO {

	private static final long serialVersionUID = -6809877761782192687L;

	/**
	 * 用户账号
	 */
	private String userAccount;

	/**
	 * 用户名称
	 */
	@NotBlank
	private String userName;

	/**
	 * 用户邮箱
	 */
	private String userEmail;

	/**
	 * 手机号码
	 */
	private String userTel;
	
	/**
	 * 用户类型
	 */
	private String userType;

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
