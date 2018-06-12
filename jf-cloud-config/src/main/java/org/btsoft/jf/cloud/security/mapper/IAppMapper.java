package org.btsoft.jf.cloud.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;
import org.btsoft.jf.cloud.security.entity.App;

@Mapper
public interface IAppMapper extends IBaseCRUDMapper<App> {

}
