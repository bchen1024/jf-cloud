package org.btsoft.jf.cloud.app.controller;

import org.btsoft.jf.cloud.app.entity.AppInfo;
import org.btsoft.jf.cloud.app.service.IAppInfoService;
import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应用信息Controller
 */
@RestController
@RequestMapping("/mgt")
public class AppInfoController implements IBaseController<AppInfo>{

    @Autowired
    private IAppInfoService service;

    @Override
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public AppInfo createSingle(@RequestBody AppInfo appInfo) {
        service.createSingle(appInfo);
        return appInfo;
    }

    @Override
    @RequestMapping(value="/single",method = RequestMethod.GET)
    public AppInfo findSingle(AppInfo appInfo) {
        return service.findSingle(appInfo);
    }

    @Override
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public AppInfo updateSingle(@RequestBody AppInfo appInfo) {
        service.updateSingle(appInfo);
        return appInfo;
    }

    @Override
    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public AppInfo deleteSingle(@RequestBody AppInfo appInfo) {
        service.deleteSingle(appInfo);
        return appInfo;
    }

    @Override
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public List<AppInfo> findList(AppInfo appInfo) {
        return service.findList(appInfo);
    }

    @Override
    @RequestMapping(value="/page",method = RequestMethod.GET)
    public PageResult<AppInfo> findPageList(AppInfo appInfo, Page page) {
        return service.findPageList(appInfo,page);
    }
}
