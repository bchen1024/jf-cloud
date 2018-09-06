package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import javax.validation.Valid;

import org.btsoft.jf.cloud.config.entity.Property;
import org.btsoft.jf.cloud.config.pojo.dto.AddPropertyDTO;
import org.btsoft.jf.cloud.config.pojo.dto.DeletePropertyDTO;
import org.btsoft.jf.cloud.config.pojo.dto.PagePropertyDTO;
import org.btsoft.jf.cloud.config.pojo.dto.UpdatePropertyDTO;
import org.btsoft.jf.cloud.config.pojo.vo.PropertyVO;
import org.btsoft.jf.cloud.config.service.IPropertyService;
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
 */
@RestController
@RequestMapping("/config/property")
@JResource(code="property",descCN="Property管理",descEN="Property Mgt")
public class PropertyController {

	@Autowired
	private IPropertyService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建Property",descEN="Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddPropertyDTO t) {
		Property entity = EntityUtils.copyProperties(t, Property.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个Property",descEN="Find Single Property")
	public CommonResult<PropertyVO> findSingle(@PathVariable("id") Long id) {
		Property entity = new Property();
		entity.setPropertyId(id);
		Property result = service.findSingle(entity);
		PropertyVO entityVO = EntityUtils.copyProperties(result, PropertyVO.class);
		return CommonResultUtils.success(entityVO);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新Property",descEN="Update Property")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdatePropertyDTO t) {
		Property entity = EntityUtils.copyProperties(t, Property.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除Property",descEN="Delete Property")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		Property entity = new Property();
		entity.setPropertyId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除Property",descEN="Batch Delete Property")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeletePropertyDTO> t) {
		List<Property> list = EntityUtils.dtoToEntityList(t, Property.class);
		return CommonResultUtils.success(service.deleteMultiple(list));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="Property列表",descEN="Property List")
	public CommonResult<PageResult<PropertyVO>> findPageList(@RequestBody PagePropertyDTO t) {
		Property entity = EntityUtils.copyProperties(t, Property.class);
		PageDTO pageDTO = EntityUtils.copyProperties(t, PageDTO.class);
		PageResult<Property> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(PropertyVO.class, result));
	}

}
