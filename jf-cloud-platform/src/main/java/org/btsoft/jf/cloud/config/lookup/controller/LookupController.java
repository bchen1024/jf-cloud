package org.btsoft.jf.cloud.config.lookup.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.config.lookup.dto.LookupAddDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupDeleteDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupQueryDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupUpdateDTO;
import org.btsoft.jf.cloud.config.lookup.service.ILookupService;
import org.btsoft.jf.cloud.config.lookup.vo.LookupVO;
import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
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
 * Lookup 控制器
 * @author chenbin
 * @date 2018-12-07 19:15
 */
@RestController
@RequestMapping("/config/lookup")
@JResource(code="lookup",descCN="Lookup管理",descEN="Lookup Mgt")
public class LookupController {

	@Autowired
	private ILookupService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code=ControllerContants.Operator.CREATE,descCN="创建Lookup",descEN="Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid LookupAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code=ControllerContants.Operator.SINGLE,descCN="查询单个Lookup",descEN="Find Single Lookup")
	public CommonResult<LookupVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code=ControllerContants.Operator.UPDATE,descCN="更新Lookup",descEN="Update Lookup")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid LookupUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code=ControllerContants.Operator.DELETE,descCN="删除Lookup",descEN="Delete Lookup")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code=ControllerContants.Operator.BATCH_DELETE,descCN="批量删除Lookup",descEN="Batch Delete Lookup")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<LookupDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code=ControllerContants.Operator.PAGE,descCN="Lookup列表",descEN="Lookup List")
	public CommonResult<PageResult<LookupVO>> findPageList(@RequestBody LookupQueryDTO dto) {
		return service.findPageList(dto);
	}

}
