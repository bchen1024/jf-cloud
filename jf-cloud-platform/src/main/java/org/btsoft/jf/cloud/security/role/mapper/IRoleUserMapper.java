package org.btsoft.jf.cloud.security.role.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseBatchMapper;
import org.btsoft.jf.cloud.security.role.entity.RoleUser;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:41:46
 */
@Mapper
public interface IRoleUserMapper extends IBaseBatchMapper<RoleUser>{
	
	/**
	 * 获取用户拥有的角色
	 * @param userRole
	 * @return
	 * @autor chenbin
	 * @date 2018-12-23 23:20
	 */
	List<Map<String,Object>> findRoleListByUser(RoleUser userRole);

}
