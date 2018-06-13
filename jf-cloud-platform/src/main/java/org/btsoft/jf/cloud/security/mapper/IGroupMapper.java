package org.btsoft.jf.cloud.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;
import org.btsoft.jf.cloud.security.entity.Group;

/**
 * @ClassName IGroupMapper
 * @Description 群组管理Mapper
 * @author bchen
 * @created 2018年4月5日 下午5:47:42
 */
@Mapper
public interface IGroupMapper extends IBaseCRUDMapper<Group> {

}
