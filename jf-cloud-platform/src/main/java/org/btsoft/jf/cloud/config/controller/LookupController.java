package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import javax.validation.Valid;

import org.btsoft.jf.cloud.config.entity.Lookup;
import org.btsoft.jf.cloud.config.pojo.dto.AddLookupDTO;
import org.btsoft.jf.cloud.config.pojo.dto.DeleteLookupDTO;
import org.btsoft.jf.cloud.config.pojo.dto.PageLookupDTO;
import org.btsoft.jf.cloud.config.pojo.dto.UpdateLookupDTO;
import org.btsoft.jf.cloud.config.pojo.vo.LookupVO;
import org.btsoft.jf.cloud.config.service.ILookupService;
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
 * Lookup Controller
 */
@RestController
@RequestMapping("/config/lookup")
@JResource(code="lookup",descCN="Lookup管理",descEN="Lookup Mgt")
public class LookupController {

	@Autowired
	private ILookupService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建Lookup",descEN="Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddLookupDTO t) {
		Lookup entity = EntityUtils.copyProperties(t, Lookup.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个Lookup",descEN="Find Single Lookup")
	public CommonResult<LookupVO> findSingle(@PathVariable("id") Long id) {
		Lookup entity = new Lookup();
		entity.setCodeId(id);
		Lookup result = service.findSingle(entity);
		LookupVO entityVO = EntityUtils.copyProperties(result, LookupVO.class);
		return CommonResultUtils.success(entityVO);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新Lookup",descEN="Update Lookup")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdateLookupDTO t) {
		Lookup entity = EntityUtils.copyProperties(t, Lookup.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除Lookup",descEN="Delete Lookup")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		Lookup entity = new Lookup();
		entity.setCodeId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除Lookup",descEN="Batch Delete Lookup")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeleteLookupDTO> t) {
		List<Lookup> list = EntityUtils.dtoToEntityList(t, Lookup.class);
		return CommonResultUtils.success(service.deleteMultiple(list));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="Lookup列表",descEN="Lookup List")
	public CommonResult<PageResult<LookupVO>> findPageList(@RequestBody PageLookupDTO t) {
		Lookup entity = EntityUtils.copyProperties(t, Lookup.class);
		PageDTO pageDTO = EntityUtils.copyProperties(t, PageDTO.class);
		PageResult<Lookup> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(LookupVO.class, result));
	}

}
