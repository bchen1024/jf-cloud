package org.btsoft.jf.cloud.config.property.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.config.property.dto.PropertyAddDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyDeleteDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyQueryDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyUpdateDTO;
import org.btsoft.jf.cloud.config.property.service.IPropertyService;
import org.btsoft.jf.cloud.config.property.vo.PropertyVO;
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
 * Property Controller
 * 
 * @author chenbin
 * @date 2018-12-07 19:30
 */
@RestController
@RequestMapping("/config/property")
@JResource(code = "property", descCN = "Property管理", descEN = "Property Mgt")
public class PropertyController {

	@Autowired
	private IPropertyService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建Property", descEN = "Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid PropertyAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个Property", descEN = "Find Single Property")
	public CommonResult<PropertyVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新Property", descEN = "Update Property")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid PropertyUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除Property", descEN = "Delete Property")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除Property", descEN = "Batch Delete Property")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<PropertyDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "Property列表", descEN = "Property List")
	public CommonResult<PageResult<PropertyVO>> findPageList(@RequestBody PropertyQueryDTO dto) {
		return service.findPageList(dto);
	}

}
