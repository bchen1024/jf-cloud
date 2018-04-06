package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.common.constant.Controller;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Group;
import org.btsoft.jf.cloud.security.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 群组Controller
 */
@RestController
@RequestMapping("/group")
@Api("群组管理API中心")
public class GroupController implements IBaseController<Group> {

	@Autowired
	private IGroupService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public Group createSingle(@RequestBody Group group) {
		return service.createSingle(group);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public Group findSingle(Group group) {
		return service.findSingle(group);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public Group updateSingle(@RequestBody Group group) {
		return service.updateSingle(group);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public Group deleteSingle(@RequestBody Group group) {
		return service.deleteSingle(group);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<Group> deleteMultiple(@RequestBody List<Group> groups) {
		service.deleteMultiple(groups);
		return groups;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<Group> findList(Group group) {
		return service.findList(group);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<Group> findPageList(Group group, Page page) {
		return service.findPageList(group, page);
	}

}
