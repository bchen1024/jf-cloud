package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.Lookup;
import org.btsoft.jf.cloud.config.service.ILookupService;
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
@RequestMapping("/lookup")
@Api("Lookup管理API中心")
public class LookupController implements IBaseController<Lookup> {

	@Autowired
	private ILookupService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public Lookup createSingle(@RequestBody Lookup lookup) {
		return service.createSingle(lookup);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public Lookup findSingle(Lookup lookup) {
		return service.findSingle(lookup);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public Lookup updateSingle(@RequestBody Lookup Lookup) {
		return service.updateSingle(Lookup);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public Lookup deleteSingle(@RequestBody Lookup Lookup) {
		return service.deleteSingle(Lookup);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<Lookup> deleteMultiple(@RequestBody List<Lookup> lookups) {
		service.deleteMultiple(lookups);
		return lookups;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<Lookup> findList(Lookup lookup) {
		return service.findList(lookup);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<Lookup> findPageList(Lookup lookup, Page page) {
		return service.findPageList(lookup, page);
	}

}
