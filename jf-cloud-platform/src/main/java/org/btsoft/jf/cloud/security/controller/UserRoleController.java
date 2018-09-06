package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.security.entity.UserRole;
import org.btsoft.jf.cloud.security.pojo.dto.AddUserRoleDTO;
import org.btsoft.jf.cloud.security.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenbin
 * @date 2018年7月3日 下午10:46:50
 */
@RestController
@RequestMapping("/security/userRole")
public class UserRoleController {

	@Autowired
	private IUserRoleService service;

	@PutMapping(ControllerContants.PATH.CREATE)
	@JOperator(code = ControllerContants.JOPERATOR.CREATE, descCN = "创建用户角色关系", descEN = "Create User Role Relations")
	@JAuditLog
	public CommonResult<Integer> createUserRoles(@RequestBody List<AddUserRoleDTO> userRoleDTO) {
		List<UserRole> userRoles = EntityUtils.dtoToEntityList(userRoleDTO, UserRole.class);
		return CommonResultUtils.success(service.createUserRoles(userRoles));
	}
}
