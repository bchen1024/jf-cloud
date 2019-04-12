package org.btsoft.jf.cloud.security.auth.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.security.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.security.auth.dto.LogoutDTO;
import org.btsoft.jf.cloud.security.auth.dto.TokenDTO;
import org.btsoft.jf.cloud.security.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.security.auth.service.IAuthService;
import org.btsoft.jf.cloud.security.auth.vo.LoginVO;
import org.btsoft.jf.cloud.security.token.service.ITokenService;
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
public class AuthController {
	
	@Autowired
	private IAuthService service;
	
	@Autowired
	private ITokenService tokenService;
	
	@PostMapping("/login")
	@JAuditLog(message="login successful")
	public CommonResult<LoginVO> login(@RequestBody @Valid LoginDTO login){
		return service.login(login);
	}
	
	@PostMapping("/logout")
	@JAuditLog(message="logout successful")
	public CommonResult<Integer> logout(@RequestBody @Valid LogoutDTO logout){
		return CommonResultUtils.success(tokenService.deleteUserToken(logout));
	}
	
	@PostMapping("/updatePassword")
	@JAuditLog(message="update password successful")
	public CommonResult<Integer> updatePassword(@RequestBody @Valid UpdatePasswordDTO dto){
		return service.updatePassword(dto);
	}
	
	@PostMapping("/user")
	public CommonResult<UserInfo> findUserByToken(@RequestBody @Valid TokenDTO userToken){
		return tokenService.findUserByToken(userToken);
	}
}
