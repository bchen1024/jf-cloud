package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.security.entity.UserRole;
import org.btsoft.jf.cloud.security.mapper.IUserRoleMapper;
import org.btsoft.jf.cloud.security.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:45:16
 */
@Service
public class UserRoleService implements IUserRoleService {
	
	@Autowired
	private IUserRoleMapper mapper;

	@Override
	public int createUserRoles(List<UserRole> userRoles) {
		if(!CollectionUtils.isEmpty(userRoles)){
			return mapper.createUserRoles(userRoles);
		}
		return 0;
	}

}
