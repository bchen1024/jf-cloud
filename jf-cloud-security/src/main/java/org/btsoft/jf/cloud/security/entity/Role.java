package org.btsoft.jf.cloud.security.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;

/**
 * @ClassName Role
 * @Description 角色信息实体类
 * @author bchen
 * @created 2018-4-3 19:09:48
 */
public class Role extends BaseEntity {

	private static final long serialVersionUID = 4114444274326269232L;

	private Long roleId;// 角色id
	private String roleCode;// 角色编码
	private String roleName;// 角色名称
	private String roleDesc;// 角色描述
	private String applyStatus;// 申请状态
	private Long roleOwner;// 角色责任人id

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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
