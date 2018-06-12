package org.btsoft.jf.cloud.core.base;

import org.btsoft.jf.cloud.core.base.entity.BaseEntity;

/**
 * 用户实体对象
 * 
 * @author bchen
 * @createDate 2018-4-12
 */
public class UserInfo extends BaseEntity {

	private static final long serialVersionUID = 6921872933864592335L;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户帐号
	 */
	private String userAccount;

	/**
	 * 用户名称
	 */
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
	 * 员工号
	 */
	private String employeeNo;

	/**
	 * 用户类型
	 */
	private String userType;

	/**
	 * 用户密码有效期
	 */
	private int userTimeout;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserTimeout() {
		return userTimeout;
	}

	public void setUserTimeout(int userTimeout) {
		this.userTimeout = userTimeout;
	}

}
