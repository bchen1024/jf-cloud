package org.btsoft.jf.cloud.security.entity;

import java.util.Date;

import org.btsoft.jf.cloud.core.base.entity.BaseEntity;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:42:04
 */
public class UserRole extends BaseEntity {

	private static final long serialVersionUID = -7839658430860883954L;
	
	private Long userId;
	
	private Long roleId;
	
	private Date beginDate;
	
	private Date endDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
