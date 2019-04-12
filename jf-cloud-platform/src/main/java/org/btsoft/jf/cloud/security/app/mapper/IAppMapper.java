package org.btsoft.jf.cloud.security.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseMapper;
import org.btsoft.jf.cloud.security.app.entity.App;

/**
 * 应用管理Mapper接口
 * @author chenbin
 * @date 2018-12-07 19:29
 */
@Mapper
public interface IAppMapper extends IBaseMapper<App> {

}
