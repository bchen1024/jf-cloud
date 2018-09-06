package org.btsoft.jf.cloud.security.pojo.dto;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class PagePermissionDTO extends PageDTO {

	private static final long serialVersionUID = 9163517858079875402L;

	private String permissionCode;

	/**
	 * 权限点中文描述
	 */
	private String permissionDescCN;

	/**
	 * 权限点英文描述
	 */
	private String permissionDescEN;

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

}
