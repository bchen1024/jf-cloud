package org.btsoft.jf.cloud.security.pojo.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class UpdatePermissionDTO extends AddPermissionDTO {

	private static final long serialVersionUID = 2901990331828940359L;

	@NotNull
	private Long permissionId;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}
