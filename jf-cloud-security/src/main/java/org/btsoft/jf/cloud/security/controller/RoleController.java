package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.common.constant.Controller;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Role;
import org.btsoft.jf.cloud.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 国际化Controller
 */
@RestController
@RequestMapping("/role")
@Api("角色管理API中心")
public class RoleController implements IBaseController<Role> {

	@Autowired
	private IRoleService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public Role createSingle(@RequestBody Role role) {
		return service.createSingle(role);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public Role findSingle(Role role) {
		return service.findSingle(role);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public Role updateSingle(@RequestBody Role role) {
		return service.updateSingle(role);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public Role deleteSingle(@RequestBody Role role) {
		return service.deleteSingle(role);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<Role> deleteMultiple(@RequestBody List<Role> roles) {
		service.deleteMultiple(roles);
		return roles;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<Role> findList(Role role) {
		return service.findList(role);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<Role> findPageList(Role role, Page page) {
		return service.findPageList(role, page);
	}

}
