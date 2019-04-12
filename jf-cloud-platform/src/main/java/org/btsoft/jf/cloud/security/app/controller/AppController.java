package org.btsoft.jf.cloud.security.app.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.security.app.dto.AppAddDTO;
import org.btsoft.jf.cloud.security.app.dto.AppDeleteDTO;
import org.btsoft.jf.cloud.security.app.dto.AppQueryDTO;
import org.btsoft.jf.cloud.security.app.dto.AppUpdateDTO;
import org.btsoft.jf.cloud.security.app.service.IAppService;
import org.btsoft.jf.cloud.security.app.vo.AppVO;
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
 * @author chenbin
 * @date 2018-12-07 19:30
 */
@RestController
@RequestMapping("/security/app")
@JResource(code = "app", descCN = "应用管理", descEN = "App Mgt")
public class AppController {

	@Autowired
	private IAppService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建应用", descEN = "Create App")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AppAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个应用", descEN = "Find Single App")
	public CommonResult<AppVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新应用", descEN = "Update App")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid AppUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除应用", descEN = "Delete App")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除应用", descEN = "Batch Delete App")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<AppDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "应用列表", descEN = "App List")
	public CommonResult<PageResult<AppVO>> findPageList(@RequestBody AppQueryDTO dto) {
		return service.findPageList(dto);
	}
	
	@PutMapping(ControllerContants.Path.SAVE)
	@JOperator(code = ControllerContants.Operator.SAVE, descCN = "保存应用", descEN = "Save App")
	@JAuditLog
	public CommonResult<Integer> saveSingle(@RequestBody @Valid AppUpdateDTO dto) {
		return service.updateSingle(dto);
	}

}
