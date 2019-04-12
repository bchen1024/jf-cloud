package org.btsoft.jf.cloud.security.group.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseMapper;
import org.btsoft.jf.cloud.security.group.entity.Group;

/**
 * @ClassName IGroupMapper
 * @Description 群组管理Mapper
 * @author bchen
 * @created 2018年4月5日 下午5:47:42
 */
@Mapper
public interface IGroupMapper extends IBaseMapper<Group> {

}
