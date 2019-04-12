package org.btsoft.jf.cloud.core.auth.user;

import java.util.Date;

import org.btsoft.jf.cloud.core.base.entity.BaseEntity;

/**
 * 
 * @author chenbin
 * @date 2018年6月27日 下午10:51:31
 */
public class UserInfo extends BaseEntity {

	private static final long serialVersionUID = -9101732352094880641L;
	
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
	private Long employeeNo;

	/**
	 * 用户类型
	 */
	private String userType;
	
	/**
	 * 用户状态
	 */
	private String userStatus;
	
	/**
	 * 密码最后更新时间
	 */
	private Date pwdUpdateTime;
	
	/**
	 * 密码错误次数
	 */
	private Integer pwdError;
	
	/**
	 * 锁定时间
	 */
	private Date lockTime;

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

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getPwdUpdateTime() {
		return pwdUpdateTime;
	}

	public void setPwdUpdateTime(Date pwdUpdateTime) {
		this.pwdUpdateTime = pwdUpdateTime;
	}

	public Integer getPwdError() {
		return pwdError;
	}

	public void setPwdError(Integer pwdError) {
		this.pwdError = pwdError;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

}
