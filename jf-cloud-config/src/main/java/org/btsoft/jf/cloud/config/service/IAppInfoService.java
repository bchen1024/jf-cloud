package org.btsoft.jf.cloud.config.service;

import org.btsoft.jf.cloud.config.entity.AppInfo;
import org.btsoft.jf.cloud.core.common.IBaseCRUDService;

public interface IAppInfoService extends IBaseCRUDService<AppInfo> {

    AppInfo findAppByCode(AppInfo appInfo);
}
