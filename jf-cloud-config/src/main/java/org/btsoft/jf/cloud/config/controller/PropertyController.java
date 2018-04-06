package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.Property;
import org.btsoft.jf.cloud.config.service.IPropertyService;
import org.btsoft.jf.cloud.core.common.IBaseController;
import org.btsoft.jf.cloud.core.common.constant.Controller;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 数据字典Controller
 */
@RestController
@RequestMapping("/property")
@Api("数据字典API中心")
public class PropertyController implements IBaseController<Property> {

	@Autowired
	private IPropertyService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public Property createSingle(@RequestBody Property property) {
		return service.createSingle(property);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public Property findSingle(Property property) {
		return service.findSingle(property);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public Property updateSingle(@RequestBody Property property) {
		return service.updateSingle(property);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public Property deleteSingle(@RequestBody Property property) {
		return service.deleteSingle(property);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<Property> deleteMultiple(@RequestBody List<Property> propertys) {
		service.deleteMultiple(propertys);
		return propertys;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<Property> findList(Property property) {
		return service.findList(property);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<Property> findPageList(Property property, Page page) {
		return service.findPageList(property, page);
	}

}
