package org.btsoft.jf.cloud.security.web.dto.permission;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 同步权限DTO对象
 * @author chenbin
 * @date 2018年6月13日 下午10:46:48
 */
public class SyncPermissionDTO extends BaseDTO {

	private static final long serialVersionUID = 7168483099560133064L;
	
	private List<AddPermissionDTO> permissionList;

	public List<AddPermissionDTO> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<AddPermissionDTO> permissionList) {
		this.permissionList = permissionList;
	}

}
