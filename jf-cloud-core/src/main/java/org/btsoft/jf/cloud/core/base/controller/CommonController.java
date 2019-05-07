package org.btsoft.jf.cloud.core.base.controller;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午10:10:45
 */
@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private ICommonService service;
	
	@GetMapping("/permission/list")
	public CommonResult<List<Map<String,String>>> listPermission(){
		return service.listPermission();
	}
	
	@PutMapping("/mapper/reload")
	public CommonResult<String> reloadMapper(){
		return service.reloadMapper();
	}

}
