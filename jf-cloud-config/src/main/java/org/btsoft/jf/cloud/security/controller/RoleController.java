package org.btsoft.jf.cloud.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.Role;
import org.btsoft.jf.cloud.security.service.IRoleService;
import org.btsoft.jf.cloud.security.web.dto.role.AddRoleDTO;
import org.btsoft.jf.cloud.security.web.dto.role.DeleteRoleDTO;
import org.btsoft.jf.cloud.security.web.dto.role.PageRoleDTO;
import org.btsoft.jf.cloud.security.web.dto.role.UpdateRoleDTO;
import org.btsoft.jf.cloud.security.web.vo.role.RoleVO;
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
 */
@RestController
@RequestMapping("/security/role")
@JResource(code="role",descCN="角色管理",descEN="Role Mgt")
public class RoleController {

	@Autowired
	private IRoleService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建角色",descEN="Create Role")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddRoleDTO t) {
		Role entity = EntityUtils.dtoToEntity(t, Role.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个角色",descEN="Find Single Role")
	public CommonResult<RoleVO> findSingle(@PathVariable("id") Long id) {
		Role entity = new Role();
		entity.setRoleId(id);
		Role result = service.findSingle(entity);
		RoleVO vo = EntityUtils.dtoToEntity(result, RoleVO.class);
		return CommonResultUtils.success(vo);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新角色",descEN="Update Role")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdateRoleDTO t) {
		Role entity = EntityUtils.dtoToEntity(t, Role.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除角色",descEN="Delete Role")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		Role entity = new Role();
		entity.setRoleId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除角色",descEN="Batch Delete Role")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeleteRoleDTO> t) {
		List<Role> appList = EntityUtils.dtoToEntityList(t, Role.class);
		return CommonResultUtils.success(service.deleteMultiple(appList));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="角色列表",descEN="Role List")
	public CommonResult<PageResult<RoleVO>> findPageList(@RequestBody PageRoleDTO t) {
		Role entity = EntityUtils.dtoToEntity(t, Role.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<Role> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(RoleVO.class, result));
	}

}
