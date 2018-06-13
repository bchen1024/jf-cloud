package org.btsoft.jf.cloud.security.web.vo.role;

import org.btsoft.jf.cloud.core.base.vo.BaseVO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午10:53:47
 */
public class RoleVO extends BaseVO {

	private static final long serialVersionUID = 1082987001974872810L;

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
