package org.btsoft.jf.cloud.security.role.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.security.role.dto.RoleAddDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleDeleteDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleQueryDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleUpdateDTO;
import org.btsoft.jf.cloud.security.role.service.IRoleService;
import org.btsoft.jf.cloud.security.role.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色信息Controller
 * 
 * @author chenbin
 * @date 2018-12-07 19:28
 */
@RestController
@RequestMapping("/security/role")
@JResource(code = "role", descCN = "角色管理", descEN = "Role Mgt")
public class RoleController {

	@Autowired
	private IRoleService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建角色", descEN = "Create Role")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid RoleAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个角色", descEN = "Find Single Role")
	public CommonResult<RoleVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新角色", descEN = "Update Role")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid RoleUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除角色", descEN = "Delete Role")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除角色", descEN = "Batch Delete Role")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<RoleDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "角色列表", descEN = "Role List")
	public CommonResult<PageResult<RoleVO>> findPageList(@RequestBody RoleQueryDTO dto) {
		return service.findPageList(dto);
	}

}
