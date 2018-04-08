package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.common.constant.Controller;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Permission;
import org.btsoft.jf.cloud.security.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 权限点Controller
 */
@RestController
@RequestMapping("/permission")
@Api("权限点管理API中心")
public class PermissioinController implements IBaseController<Permission> {

	@Autowired
	private IPermissionService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public Permission createSingle(@RequestBody Permission permission) {
		return service.createSingle(permission);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public Permission findSingle(Permission permission) {
		return service.findSingle(permission);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public Permission updateSingle(@RequestBody Permission permission) {
		return service.updateSingle(permission);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public Permission deleteSingle(@RequestBody Permission permission) {
		return service.deleteSingle(permission);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<Permission> deleteMultiple(@RequestBody List<Permission> permissions) {
		service.deleteMultiple(permissions);
		return permissions;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<Permission> findList(Permission permission) {
		return service.findList(permission);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<Permission> findPageList(Permission permission, Page page) {
		return service.findPageList(permission, page);
	}

}
