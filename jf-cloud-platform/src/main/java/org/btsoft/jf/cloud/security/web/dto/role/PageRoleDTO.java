package org.btsoft.jf.cloud.security.web.dto.role;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class PageRoleDTO extends PageDTO {

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

}
