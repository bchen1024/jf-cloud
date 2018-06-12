package org.btsoft.jf.cloud.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;
import org.btsoft.jf.cloud.security.entity.Permission;

/**
 * @ClassName IPermissionMapper
 * @Description 权限点Mapper接口
 * @author bchen
 * @created 2018-4-8 23:32:48
 */
@Mapper
public interface IPermissionMapper extends IBaseCRUDMapper<Permission> {

}
