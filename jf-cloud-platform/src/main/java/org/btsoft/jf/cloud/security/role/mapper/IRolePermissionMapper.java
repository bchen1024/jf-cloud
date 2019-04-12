package org.btsoft.jf.cloud.security.role.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseBatchMapper;
import org.btsoft.jf.cloud.security.role.entity.RolePermission;

/**
 * @author chenbin
 * @date 2018-12-24 00:53
 */
@Mapper
public interface IRolePermissionMapper extends IBaseBatchMapper<RolePermission> {
	
	/**
	 * 获取角色下的所有权限点
	 * @param batch
	 * @return
	 * @autor chenbin
	 * @date 2018-12-24 00:55
	 */
	List<String> findPermissionListByUser(List<Long> roleIdList);

}
