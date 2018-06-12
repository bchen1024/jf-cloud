package org.btsoft.jf.cloud.security.web.dto.role;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class UpdateRoleDTO extends AddRoleDTO {

	private static final long serialVersionUID = 2541516912347878725L;

	@NotNull
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
