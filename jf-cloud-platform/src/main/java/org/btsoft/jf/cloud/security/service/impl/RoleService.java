package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.Role;
import org.btsoft.jf.cloud.security.mapper.IRoleMapper;
import org.btsoft.jf.cloud.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * @ClassName RoleService
 * @Description 角色管理Service实现类
 * @author bchen
 * @created 2018年4月3日 下午7:25:05
 */
@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleMapper mapper;

	@Override
	public int createSingle(Role role) {
		return mapper.createSingle(role);
	}

	@Override
	public Role findSingle(Role role) {
		return mapper.findSingle(role);
	}

	@Override
	public int updateSingle(Role role) {
		return mapper.updateSingle(role);
	}

	@Override
	public int deleteSingle(Role role) {
		return mapper.deleteSingle(role);
	}

	@Override
	public int deleteMultiple(List<Role> roles) {
		if (!CollectionUtils.isEmpty(roles)) {
			return mapper.deleteMultiple(roles);
		}
		return 0;
	}

	@Override
	public PageResult<Role> findPageList(Role entity, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<Role> result = mapper.findPageList(entity);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
