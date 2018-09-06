package org.btsoft.jf.cloud.security.pojo.vo;

import org.btsoft.jf.cloud.core.base.vo.BaseVO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午10:53:47
 */
public class PermissionVO extends BaseVO {

	private static final long serialVersionUID = 1082987001974872810L;

	/**
	 * 权限点id,流水号
	 */
	private Long permissionId;

	/**
	 * 权限code
	 */
	private String permissionCode;

	/**
	 * 权限点中文描述
	 */
	private String permissionDescCN;

	/**
	 * 权限点英文描述
	 */
	private String permissionDescEN;

	/**
	 * 权限点类型：resources：资源;method：方法
	 */
	private String permissionType;

	/**
	 * 权限来源，custom:自定义手动添加；annotation:注解扫描
	 */
	private String permissionSource;

	/**
	 * 父编码
	 */
	private String parentCode;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionDescCN() {
		return permissionDescCN;
	}

	public void setPermissionDescCN(String permissionDescCN) {
		this.permissionDescCN = permissionDescCN;
	}

	public String getPermissionDescEN() {
		return permissionDescEN;
	}

	public void setPermissionDescEN(String permissionDescEN) {
		this.permissionDescEN = permissionDescEN;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermissionSource() {
		return permissionSource;
	}

	public void setPermissionSource(String permissionSource) {
		this.permissionSource = permissionSource;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
