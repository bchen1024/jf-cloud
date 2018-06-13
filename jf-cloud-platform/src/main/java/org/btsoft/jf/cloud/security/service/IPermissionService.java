package org.btsoft.jf.cloud.security.service;

import java.util.List;

import org.btsoft.jf.cloud.core.base.service.IBaseCRUDService;
import org.btsoft.jf.cloud.security.entity.Permission;

/**
 * @ClassName IPermissionService
 * @Description 权限点Service接口
 * @author bchen
 * @created 2018-4-8 23:34:48
 */
public interface IPermissionService extends IBaseCRUDService<Permission>{
	
	/**
	 * 同步系统权限点
	 * @param list
	 * @return
	 */
	int syncPermission(List<Permission> list);

}
