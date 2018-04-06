package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.I18n;
import org.btsoft.jf.cloud.config.service.II18nService;
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
 * 国际化Controller
 */
@RestController
@RequestMapping("/i18n")
@Api("国际化API中心")
public class I18nController implements IBaseController<I18n> {

	@Autowired
	private II18nService service;

	@Override
	@RequestMapping(value = Controller.PATH.CREATE, method = RequestMethod.POST)
	@ApiOperation(value = Controller.API.CREATE)
	public I18n createSingle(@RequestBody I18n i18n) {
		return service.createSingle(i18n);
	}

	@Override
	@RequestMapping(value = Controller.PATH.SINGLE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.SINGLE)
	public I18n findSingle(I18n i18n) {
		return service.findSingle(i18n);
	}

	@Override
	@RequestMapping(value = Controller.PATH.UPDATE, method = RequestMethod.PUT)
	@ApiOperation(value = Controller.API.UPDATE)
	public I18n updateSingle(@RequestBody I18n i18n) {
		return service.updateSingle(i18n);
	}

	@Override
	@RequestMapping(value = Controller.PATH.DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.DELETE)
	public I18n deleteSingle(@RequestBody I18n i18n) {
		return service.deleteSingle(i18n);
	}

	@Override
	@RequestMapping(value = Controller.PATH.BATCH_DELETE, method = RequestMethod.DELETE)
	@ApiOperation(value = Controller.API.BATCH_DELETE)
	public List<I18n> deleteMultiple(@RequestBody List<I18n> i18ns) {
		service.deleteMultiple(i18ns);
		return i18ns;
	}

	@Override
	@RequestMapping(value = Controller.PATH.LIST, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.LIST)
	public List<I18n> findList(I18n i18n) {
		return service.findList(i18n);
	}

	@Override
	@RequestMapping(value = Controller.PATH.PAGE, method = RequestMethod.GET)
	@ApiOperation(value = Controller.API.PAGE)
	public PageResult<I18n> findPageList(I18n i18n, Page page) {
		return service.findPageList(i18n, page);
	}

}
