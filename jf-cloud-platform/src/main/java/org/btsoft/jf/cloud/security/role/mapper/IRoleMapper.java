package org.btsoft.jf.cloud.security.role.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseMapper;
import org.btsoft.jf.cloud.security.role.entity.Role;

/**
 * @ClassName IRoleMapper
 * @Description 角色Mapper接口
 * @author bchen
 * @created 2018年4月3日 下午7:18:45
 */
@Mapper
public interface IRoleMapper extends IBaseMapper<Role> {
	
	List<Map<String,Object>> findRoleList(List<Long> roleList);
}
