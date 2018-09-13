package org.btsoft.jf.cloud.sso.auth.controller;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.sso.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenbin
 * @date 2018年9月12日 下午9:10:02
 */
@RestController
@RequestMapping("/user")
public class UserQueryController {
	
	@Autowired
	private IUserService service;

	@PostMapping("/list")
	public CommonResult<List<UserInfo>> getUserListById(@RequestBody List<Long> userIdList){
		return CommonResultUtils.success(EntityUtils.dtoToEntityList(service.findUserListById(userIdList), UserInfo.class));
	}
	
	@PostMapping("/map")
	public CommonResult<Map<Long, UserInfo>> getUserMapById(@RequestBody List<Long> userIdList){
		return CommonResultUtils.success(service.findUserMapById(userIdList));
	}
}
