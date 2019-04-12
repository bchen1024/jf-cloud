package org.btsoft.jf.cloud.security.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.core.base.mapper.IBaseMapper;
import org.btsoft.jf.cloud.security.permission.entity.Permission;

/**
 * @ClassName IPermissionMapper
 * @Description 权限点Mapper接口
 * @author bchen
 * @created 2018-4-8 23:32:48
 */
@Mapper
public interface IPermissionMapper extends IBaseMapper<Permission> {
	
	/**
	 * 同步系统权限点
	 * @param list
	 * @return
	 */
	int syncPermission(@Param("list")List<Permission> list);

}