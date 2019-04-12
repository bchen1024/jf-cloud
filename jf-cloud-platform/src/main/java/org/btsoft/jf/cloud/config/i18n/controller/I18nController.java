package org.btsoft.jf.cloud.config.i18n.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.config.i18n.dto.I18nAddDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nDeleteDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nQueryDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nUpdateDTO;
import org.btsoft.jf.cloud.config.i18n.service.II18nService;
import org.btsoft.jf.cloud.config.i18n.vo.I18nVO;
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
 * 国际化Controller
 * 
 * @author chenbin
 * @date 2018-12-07 19:15
 */
@RestController
@RequestMapping("/config/i18n")
@JResource(code = "i18n", descCN = "国际化管理", descEN = "I18n Mgt")
public class I18nController {

	@Autowired
	private II18nService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建国际化", descEN = "Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid I18nAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个国际化", descEN = "Find Single I18n")
	public CommonResult<I18nVO> findSingle(@PathVariable("id") @NotNull Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新国际化", descEN = "Update I18n")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid I18nUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除国际化", descEN = "Delete I18n")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除国际化", descEN = "Batch Delete I18n")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<I18nDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "国际化列表", descEN = "I18n List")
	public CommonResult<PageResult<I18nVO>> findPageList(@RequestBody I18nQueryDTO dto) {
		return service.findPageList(dto);
	}

}
