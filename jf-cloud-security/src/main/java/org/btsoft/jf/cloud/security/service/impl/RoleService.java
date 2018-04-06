package org.btsoft.jf.cloud.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Role;
import org.btsoft.jf.cloud.security.mapper.IRoleMapper;
import org.btsoft.jf.cloud.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Role createSingle(Role role) {
		mapper.createSingle(role);
		return role;
	}

	@Override
	public Role findSingle(Role role) {
		return mapper.findSingle(role);
	}

	@Override
	public Role updateSingle(Role role) {
		mapper.updateSingle(role);
		return role;
	}

	@Override
	public Role deleteSingle(Role role) {
		Role single = this.findSingle(role);
		if (single != null) {
			mapper.deleteSingle(single);
		}
		return single;
	}

	@Override
	public void deleteMultiple(List<Role> roles) {
		if (roles != null && !roles.isEmpty()) {
			mapper.deleteMultiple(roles);
		}
	}

	@Override
	public List<Role> findList(Role role) {
		return mapper.findList(role);
	}

	@Override
	public PageResult<Role> findPageList(Role role, Page page) {
		int total = mapper.findCount(role);
		List<Role> result = new ArrayList<Role>();
		if (total > 0) {
			result = mapper.findPageList(role, page);
		}
		return new PageResult<Role>(result, page, total);
	}

}
