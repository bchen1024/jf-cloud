package org.btsoft.jf.cloud.security.user.controller;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.security.user.dto.UserAddDTO;
import org.btsoft.jf.cloud.security.user.dto.UserQueryDTO;
import org.btsoft.jf.cloud.security.user.service.IUserService;
import org.hibernate.validator.constraints.NotEmpty;
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
@RequestMapping("/security/user")
@JResource(code = "user", descCN = "用户管理", descEN = "User Mgt")
public class UserController {
	
	@Autowired
	private IUserService service;

	@PostMapping("/list")
	public CommonResult<List<UserInfo>> findUserListByUserId(@NotEmpty @RequestBody List<Long> userIdList){
		return service.findUserListByUserId(userIdList);
	}
	
	@PostMapping("/map")
	public CommonResult<Map<Long, UserInfo>> findUserMapByUserId(@NotEmpty @RequestBody List<Long> userIdList){
		return service.findUserMapByUserId(userIdList);
	}
	
	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "用户列表", descEN = "User List")
	public CommonResult<PageResult<UserInfo>> findUserPage(@RequestBody UserQueryDTO dto){
		return service.findPageList(dto);
	}
	
	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建用户", descEN = "Create User")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody UserAddDTO dto){
		return service.createSingle(dto);
	}
}
