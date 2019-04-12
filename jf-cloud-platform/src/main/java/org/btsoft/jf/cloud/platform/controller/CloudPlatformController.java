package org.btsoft.jf.cloud.platform.controller;

import org.btsoft.jf.cloud.core.auth.user.RequestContextUser;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.platform.dto.CurrentUserQueryDTO;
import org.btsoft.jf.cloud.platform.service.ICloudPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 云平台controller
 * @author chenbin
 * @date 2018-12-22 22:15
 */
@RestController
public class CloudPlatformController {
	
	@Autowired
	private ICloudPlatformService service;
	
	@PostMapping("/current")
	public CommonResult<RequestContextUser> findCurrentUser(@RequestBody CurrentUserQueryDTO dto){
		return service.findCurrentUser(dto);
	}

}
