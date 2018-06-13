package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.App;
import org.btsoft.jf.cloud.security.service.IAppService;
import org.btsoft.jf.cloud.security.web.dto.app.AddAppDTO;
import org.btsoft.jf.cloud.security.web.dto.app.DeleteAppDTO;
import org.btsoft.jf.cloud.security.web.dto.app.PageAppDTO;
import org.btsoft.jf.cloud.security.web.dto.app.UpdateAppDTO;
import org.btsoft.jf.cloud.security.web.vo.app.AppVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用信息Controller
 */
@RestController
@RequestMapping("/security/app")
@JResource(code="app",descCN="应用管理",descEN="App Mgt")
public class AppController {

	@Autowired
	private IAppService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建应用",descEN="Create App")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddAppDTO t) {
		App entity = EntityUtils.dtoToEntity(t, App.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个应用",descEN="Find Single App")
	public CommonResult<AppVO> findSingle(@PathVariable("id") Long id) {
		App entity = new App();
		entity.setAppId(id);
		App result = service.findSingle(entity);
		AppVO vo = EntityUtils.dtoToEntity(result, AppVO.class);
		return CommonResultUtils.success(vo);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新应用",descEN="Update App")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdateAppDTO t) {
		App entity = EntityUtils.dtoToEntity(t, App.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除应用",descEN="Delete App")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		App entity = new App();
		entity.setAppId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除应用",descEN="Batch Delete App")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeleteAppDTO> t) {
		List<App> appList = EntityUtils.dtoToEntityList(t, App.class);
		return CommonResultUtils.success(service.deleteMultiple(appList));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="应用列表",descEN="App List")
	public CommonResult<PageResult<AppVO>> findPageList(@RequestBody PageAppDTO t) {
		App entity = EntityUtils.dtoToEntity(t, App.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<App> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(AppVO.class, result));
	}

}
