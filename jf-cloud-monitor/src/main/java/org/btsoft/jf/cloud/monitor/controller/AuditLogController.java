package org.btsoft.jf.cloud.monitor.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.entity.AuditLog;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.monitor.service.IAuditLogService;
import org.btsoft.jf.cloud.monitor.web.dto.PageAuditLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午11:46:23
 */
@RestController
@RequestMapping("/auditLog")
public class AuditLogController {
	
	@Autowired
	private IAuditLogService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	public CommonResult<Integer> createSingle(@RequestBody @Valid AuditLog t) {
		return CommonResultUtils.success(service.createSingle(t));
	}
	
	@PostMapping(ControllerContants.PATH.PAGE)
	public CommonResult<PageResult<AuditLog>> findPageList(@RequestBody PageAuditLogDTO t) {
		AuditLog entity = EntityUtils.dtoToEntity(t, AuditLog.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<AuditLog> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(result);
	}

}
