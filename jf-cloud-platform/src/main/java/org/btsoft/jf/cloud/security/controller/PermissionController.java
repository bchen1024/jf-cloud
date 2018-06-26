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
import org.btsoft.jf.cloud.security.entity.Permission;
import org.btsoft.jf.cloud.security.service.IPermissionService;
import org.btsoft.jf.cloud.security.web.dto.permission.AddPermissionDTO;
import org.btsoft.jf.cloud.security.web.dto.permission.DeletePermissionDTO;
import org.btsoft.jf.cloud.security.web.dto.permission.PagePermissionDTO;
import org.btsoft.jf.cloud.security.web.dto.permission.SyncPermissionDTO;
import org.btsoft.jf.cloud.security.web.dto.permission.UpdatePermissionDTO;
import org.btsoft.jf.cloud.security.web.vo.permission.PermissionVO;
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
 * 权限点信息Controller
 */
@RestController
@RequestMapping("/security/permission")
@JResource(code="permission",descCN="权限点管理",descEN="Permission Mgt")
public class PermissionController {

	@Autowired
	private IPermissionService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建权限点",descEN="Create Permission")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddPermissionDTO t) {
		Permission entity = EntityUtils.dtoToEntity(t, Permission.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个权限点",descEN="Find Single Permission")
	public CommonResult<PermissionVO> findSingle(@PathVariable("id") Long id) {
		Permission entity = new Permission();
		entity.setPermissionId(id);
		Permission result = service.findSingle(entity);
		PermissionVO vo = EntityUtils.dtoToEntity(result, PermissionVO.class);
		return CommonResultUtils.success(vo);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新权限点",descEN="Update Permission")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdatePermissionDTO t) {
		Permission entity = EntityUtils.dtoToEntity(t, Permission.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除权限点",descEN="Delete Permission")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		Permission entity = new Permission();
		entity.setPermissionId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除权限点",descEN="Batch Delete Permission")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeletePermissionDTO> t) {
		List<Permission> appList = EntityUtils.dtoToEntityList(t, Permission.class);
		return CommonResultUtils.success(service.deleteMultiple(appList));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="权限点列表",descEN="Permission List")
	public CommonResult<PageResult<PermissionVO>> findPageList(@RequestBody PagePermissionDTO t) {
		Permission entity = EntityUtils.dtoToEntity(t, Permission.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<Permission> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(PermissionVO.class, result));
	}
	
	@PutMapping(ControllerContants.PATH.SYNC)
	@JAuditLog
	public CommonResult<Integer> sysPermission(@RequestBody SyncPermissionDTO dto){
		List<Permission> entityList = EntityUtils.dtoToEntityList(dto.getPermissionList(), Permission.class);
		return CommonResultUtils.success(service.syncPermission(entityList));
	}

}
