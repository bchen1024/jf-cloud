package org.btsoft.jf.cloud.security.role.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.entity.AppEntity;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:42:04
 */
public class RoleUser extends AppEntity {

	private static final long serialVersionUID = -7839658430860883954L;
	
	private Long id;
	
	private Long userId;
	
	private Long roleId;
	
	private Date beginDate;
	
	private Date endDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
