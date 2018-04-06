package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.AppInfo;
import org.btsoft.jf.cloud.config.service.IAppInfoService;
import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.common.constant.Controller;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应用信息Controller
 */
@RestController
@RequestMapping("/app")
@Api("应用管理中心")
public class AppInfoController implements IBaseController<AppInfo>{

    @Autowired
    private IAppInfoService service;

    @Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public AppInfo createSingle(@RequestBody AppInfo appInfo) {
		return service.createSingle(appInfo);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public AppInfo findSingle(AppInfo appInfo) {
		return service.findSingle(appInfo);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public AppInfo updateSingle(@RequestBody AppInfo appInfo) {
		return service.updateSingle(appInfo);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public AppInfo deleteSingle(@RequestBody AppInfo appInfo) {
		return service.deleteSingle(appInfo);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<AppInfo> deleteMultiple(@RequestBody List<AppInfo> appInfos) {
		service.deleteMultiple(appInfos);
		return appInfos;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<AppInfo> findList(AppInfo appInfo) {
		return service.findList(appInfo);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<AppInfo> findPageList(AppInfo appInfo, Page page) {
		return service.findPageList(appInfo, page);
	}

    @RequestMapping(value="/{appCode}",method = RequestMethod.GET)
    @ApiOperation(value = "根据应用编码获取单个应用")
    public AppInfo findAppByCode(@PathVariable("appCode") String appCode){
        AppInfo appInfo=new AppInfo();
        appInfo.setAppCode(appCode);
        return service.findAppByCode(appInfo);
    }
}
