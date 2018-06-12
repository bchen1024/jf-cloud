package org.btsoft.jf.cloud.security.web.dto.role;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class DeleteRoleDTO extends BaseDTO {

	private static final long serialVersionUID = 7419599270900974420L;

	@NotNull
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
