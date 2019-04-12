package org.btsoft.jf.cloud.security.role.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppPageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class RoleQueryDTO extends AppPageDTO {

	private static final long serialVersionUID = 3369405772221024809L;
	
	private String roleCode;
	private String roleName;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
