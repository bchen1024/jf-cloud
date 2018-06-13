package org.btsoft.jf.cloud.core.base.controller;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.service.IAdminService;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午10:10:45
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	@PutMapping("/permission/sync")
	@JOperator(code=ControllerContants.JOPERATOR.SYNC,descCN="同步权限",descEN="Sync Permission")
	@JAuditLog
	public CommonResult<Integer> syncPermission(){
		return CommonResultUtils.success(service.syncPermission());
	}

}
