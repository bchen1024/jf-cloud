package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.Permission;
import org.btsoft.jf.cloud.security.mapper.IPermissionMapper;
import org.btsoft.jf.cloud.security.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

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
	public int createSingle(Permission permission) {
		return mapper.createSingle(permission);
	}

	@Override
	public Permission findSingle(Permission permission) {
		return mapper.findSingle(permission);
	}

	@Override
	public int updateSingle(Permission permission) {
		return mapper.updateSingle(permission);
	}

	@Override
	public int deleteSingle(Permission permission) {
		return mapper.deleteSingle(permission);
	}

	@Override
	public int deleteMultiple(List<Permission> permissions) {
		if (!CollectionUtils.isEmpty(permissions)) {
			return mapper.deleteMultiple(permissions);
		}
		return 0;
	}

	@Override
	public PageResult<Permission> findPageList(Permission entity, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<Permission> result = mapper.findPageList(entity);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
