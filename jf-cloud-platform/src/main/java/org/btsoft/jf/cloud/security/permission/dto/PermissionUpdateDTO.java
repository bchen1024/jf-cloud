package org.btsoft.jf.cloud.security.permission.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class PermissionUpdateDTO extends PermissionAddDTO {

	private static final long serialVersionUID = 2901990331828940359L;

	@NotNull
	private Long permissionId;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
