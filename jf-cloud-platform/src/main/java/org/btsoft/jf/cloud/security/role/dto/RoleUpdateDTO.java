package org.btsoft.jf.cloud.security.role.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class RoleUpdateDTO extends RoleAddDTO {

	private static final long serialVersionUID = 2541516912347878725L;

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
