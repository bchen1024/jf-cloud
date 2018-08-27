package org.btsoft.jf.cloud.security.controller;

import org.btsoft.jf.cloud.core.auth.context.RequestUser;
import org.btsoft.jf.cloud.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年7月2日 下午10:58:01
 */
@RestController
@RequestMapping("/security/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/token")
	public RequestUser findUser(@RequestHeader String token){
		return service.findUser(token);
	}
}
