package org.btsoft.jf.cloud.monitor.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.monitor.entity.AuditLog;
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
@JResource(code = "auditLog", descCN = "审计日志", descEN = "Audit Log Mgt",appCode="jf-cloud-platform")
@RequestMapping("/auditLog")
public class AuditLogController {
	
	@Autowired
	private IAuditLogService service;

	@PostMapping(ControllerContants.Path.CREATE)
	public CommonResult<Integer> createSingle(@RequestBody @Valid AuditLog t) {
		return CommonResultUtils.success(service.createSingle(t));
	}
	
	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "审计日志列表", descEN = "Audit Log List")
	public CommonResult<PageResult<AuditLog>> findPageList(@RequestBody PageAuditLogDTO t) {
		AuditLog entity = EntityUtils.copyProperties(t, AuditLog.class);
		PageDTO pageDTO = EntityUtils.copyProperties(t, PageDTO.class);
		PageResult<AuditLog> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(result);
	}

}
