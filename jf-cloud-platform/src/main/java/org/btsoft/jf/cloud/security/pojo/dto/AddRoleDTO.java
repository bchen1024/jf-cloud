package org.btsoft.jf.cloud.security.pojo.dto;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class AddRoleDTO extends BaseDTO {

	private static final long serialVersionUID = -2248014530125495815L;

	@NotBlank
	private String roleCode;// 角色编码
	@NotBlank
	private String roleName;// 角色名称
	private String roleDesc;// 角色描述
	@NotBlank
	private String applyStatus;// 申请状态
	@NotNull
	private Long roleOwner;// 角色责任人id

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

}
