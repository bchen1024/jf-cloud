package org.btsoft.jf.cloud.security.service;

import java.util.List;

import org.btsoft.jf.cloud.security.entity.UserRole;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:44:48
 */
public interface IUserRoleService {
	
	int createUserRoles(List<UserRole> userRoles);

}
