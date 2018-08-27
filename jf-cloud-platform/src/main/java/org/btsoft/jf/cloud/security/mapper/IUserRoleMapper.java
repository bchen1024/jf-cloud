package org.btsoft.jf.cloud.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.security.entity.UserRole;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:41:46
 */
@Mapper
public interface IUserRoleMapper {
	
	int createUserRoles(@Param("list") List<UserRole> userRoles);
	
	List<UserRole> findPageList(@Param("vo") UserRole userRole);

}
