package org.btsoft.jf.cloud.security.permission.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class PermissionDeleteDTO extends AppDTO {

	private static final long serialVersionUID = 7419599270900974420L;

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
