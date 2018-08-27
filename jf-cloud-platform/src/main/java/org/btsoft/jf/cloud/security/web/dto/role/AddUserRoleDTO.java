package org.btsoft.jf.cloud.security.web.dto.role;

import java.util.Date;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:54:03
 */
public class AddUserRoleDTO extends BaseDTO {

	private static final long serialVersionUID = 8745046898366505700L;
	
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
