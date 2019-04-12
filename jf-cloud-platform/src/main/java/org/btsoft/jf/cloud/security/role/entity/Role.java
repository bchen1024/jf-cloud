package org.btsoft.jf.cloud.security.role.entity;

import org.btsoft.jf.cloud.core.base.entity.AppEntity;

/**
 * @ClassName Role
 * @Description 角色信息实体类
 * @author bchen
 * @created 2018-4-3 19:09:48
 */
public class Role extends AppEntity {

	private static final long serialVersionUID = 4114444274326269232L;

	/**
	 * 角色id
	 */
	private Long roleId;
	/**
	 * 角色编码
	 */
	private String roleCode;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色描述
	 */
	private String roleDesc;
	/**
	 * 申请状态
	 */
	private String applyStatus;
	/**
	 * 角色责任人id
	 */
	private Long roleOwner;

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
