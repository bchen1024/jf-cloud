package org.btsoft.jf.cloud.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Permission;
import org.btsoft.jf.cloud.security.mapper.IPermissionMapper;
import org.btsoft.jf.cloud.security.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PermissionService
 * @Description 权限点Service实现类
 * @author bchen
 * @created 2018-4-8 23:35:48
 */
@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private IPermissionMapper mapper;

	@Override
	public Permission createSingle(Permission permission) {
		mapper.createSingle(permission);
		return permission;
	}

	@Override
	public Permission findSingle(Permission permission) {
		return mapper.findSingle(permission);
	}

	@Override
	public Permission updateSingle(Permission permission) {
		mapper.updateSingle(permission);
		return permission;
	}

	@Override
	public Permission deleteSingle(Permission permission) {
		Permission single = this.findSingle(permission);
		if (single != null) {
			mapper.deleteSingle(single);
		}
		return single;
	}

	@Override
	public void deleteMultiple(List<Permission> permissions) {
		if (permissions != null && !permissions.isEmpty()) {
			mapper.deleteMultiple(permissions);
		}
	}

	@Override
	public List<Permission> findList(Permission permission) {
		return mapper.findList(permission);
	}

	@Override
	public PageResult<Permission> findPageList(Permission permission, Page page) {
		int total = mapper.findCount(permission);
		List<Permission> result = new ArrayList<Permission>();
		if (total > 0) {
			result = mapper.findPageList(permission, page);
		}
		return new PageResult<Permission>(result, page, total);
	}

}
