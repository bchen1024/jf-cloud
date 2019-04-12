package org.btsoft.jf.cloud.security.role.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class RoleAddDTO extends AppDTO {

	private static final long serialVersionUID = -2248014530125495815L;

	/**
	 * 角色编码
	 */
	@NotBlank
	private String roleCode;
	/**
	 * 角色名称
	 */
	@NotBlank
	private String roleName;
	/**
	 * 角色描述
	 */
	private String roleDesc;
	/**
	 * // 申请状态
	 */
	@NotBlank
	private String applyStatus;
	/**
	 * 角色责任人id
	 */
	@NotNull
	private Long roleOwner;

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

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Long getRoleOwner() {
		return roleOwner;
	}

	public void setRoleOwner(Long roleOwner) {
		this.roleOwner = roleOwner;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
