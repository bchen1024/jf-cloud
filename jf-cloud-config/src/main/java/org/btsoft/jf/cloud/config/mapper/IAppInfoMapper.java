package org.btsoft.jf.cloud.config.mapper;

import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.config.entity.AppInfo;
import org.btsoft.jf.cloud.core.common.IBaseCRUDMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppInfoMapper extends IBaseCRUDMapper<AppInfo> {

    AppInfo findAppByCode(@Param("vo") AppInfo appInfo);
}