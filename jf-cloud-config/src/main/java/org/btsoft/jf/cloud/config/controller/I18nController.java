package org.btsoft.jf.cloud.config.controller;

import java.util.List;

import javax.validation.Valid;

import org.btsoft.jf.cloud.config.entity.I18n;
import org.btsoft.jf.cloud.config.service.II18nService;
import org.btsoft.jf.cloud.config.web.dto.i18n.AddI18nDTO;
import org.btsoft.jf.cloud.config.web.dto.i18n.DeleteI18nDTO;
import org.btsoft.jf.cloud.config.web.dto.i18n.PageI18nDTO;
import org.btsoft.jf.cloud.config.web.dto.i18n.UpdateI18nDTO;
import org.btsoft.jf.cloud.config.web.vo.i18n.I18nVO;
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
 * 国际化Controller
 */
@RestController
@RequestMapping("/config/i18n")
@JResource(code="i18n",descCN="国际化管理",descEN="I18n Mgt")
public class I18nController {

	@Autowired
	private II18nService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建国际化",descEN="Create I18n")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddI18nDTO t) {
		I18n entity = EntityUtils.dtoToEntity(t, I18n.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个国际化",descEN="Find Single I18n")
	public CommonResult<I18nVO> findSingle(@PathVariable("id") Long id) {
		I18n entity = new I18n();
		entity.setI18nId(id);
		I18n result = service.findSingle(entity);
		I18nVO entityVO = EntityUtils.dtoToEntity(result, I18nVO.class);
		return CommonResultUtils.success(entityVO);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新国际化",descEN="Update I18n")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdateI18nDTO t) {
		I18n entity = EntityUtils.dtoToEntity(t, I18n.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除国际化",descEN="Delete I18n")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		I18n entity = new I18n();
		entity.setI18nId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除国际化",descEN="Batch Delete I18n")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeleteI18nDTO> t) {
		List<I18n> list = EntityUtils.dtoToEntityList(t, I18n.class);
		return CommonResultUtils.success(service.deleteMultiple(list));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="国际化列表",descEN="I18n List")
	public CommonResult<PageResult<I18nVO>> findPageList(@RequestBody PageI18nDTO t) {
		I18n entity = EntityUtils.dtoToEntity(t, I18n.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<I18n> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(I18nVO.class, result));
	}

}
