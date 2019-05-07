package org.btsoft.jf.cloud.security.role.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class RoleDeleteDTO extends AppDTO {

	private static final long serialVersionUID = 7419599270900974420L;

	@NotNull
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
