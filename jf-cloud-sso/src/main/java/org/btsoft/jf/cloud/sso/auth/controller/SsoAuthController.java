package org.btsoft.jf.cloud.sso.auth.controller;

import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.sso.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.sso.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.sso.auth.service.IUserService;
import org.btsoft.jf.cloud.sso.auth.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午9:50:02
 */
@RestController
@RequestMapping("/auth")
public class SsoAuthController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/login")
	public CommonResult<LoginVO> login(@RequestBody LoginDTO login){
		LoginVO loginVO=service.login(login);
		return CommonResultUtils.success(loginVO);
	}
	
	@PostMapping("/updatePassword")
	public CommonResult<Integer> updatePassword(@RequestBody UpdatePasswordDTO dto){
		return CommonResultUtils.success(service.updatePassword(dto));
	}
}
