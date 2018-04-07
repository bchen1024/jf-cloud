package org.btsoft.jf.cloud.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("应用管理中心")
public class AppInfoController implements IBaseController<AppInfo>{

    @Autowired
    private IAppInfoService service;

    @Override
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ApiOperation(value = "创建单个应用")
    public AppInfo createSingle(@RequestBody AppInfo appInfo) {
        return service.createSingle(appInfo);
    }

    @Override
    @RequestMapping(value="/single",method = RequestMethod.GET)
    @ApiOperation(value = "获取单个应用")
    public AppInfo findSingle(AppInfo appInfo) {
        return service.findSingle(appInfo);
    }

    @Override
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ApiOperation(value = "更新单个应用")
    public AppInfo updateSingle(@RequestBody AppInfo appInfo) {
        return service.updateSingle(appInfo);
    }

    @Override
    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除单个应用")
    public AppInfo deleteSingle(@RequestBody AppInfo appInfo) {
        return service.deleteSingle(appInfo);
    }
    
    @Override
    @RequestMapping(value="/batch/delete",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除多个应用")
    public List<AppInfo> deleteMultiple(@RequestBody List<AppInfo> appInfos) {
    	service.deleteMultiple(appInfos);
    	return appInfos;
    }

    @Override
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiOperation(value = "获取应用列表")
    public List<AppInfo> findList(AppInfo appInfo) {
        return service.findList(appInfo);
    }

    @Override
    @RequestMapping(value="/page",method = RequestMethod.GET)
    @ApiOperation(value = "获取应用分页列表")
    public PageResult<AppInfo> findPageList(AppInfo appInfo, Page page) {
        return service.findPageList(appInfo,page);
    }

    @RequestMapping(value="/{appCode}",method = RequestMethod.GET)
    @ApiOperation(value = "根据应用编码获取单个应用")
    public AppInfo findAppByCode(@PathVariable("appCode") String appCode){
        AppInfo appInfo=new AppInfo();
        appInfo.setAppCode(appCode);
        return service.findAppByCode(appInfo);
    }
}
