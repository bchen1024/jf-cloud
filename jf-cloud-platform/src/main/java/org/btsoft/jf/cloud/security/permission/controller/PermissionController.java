package org.btsoft.jf.cloud.security.permission.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.security.permission.dto.PermissionAddDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionDeleteDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionQueryDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionSyncDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionUpdateDTO;
import org.btsoft.jf.cloud.security.permission.service.IPermissionService;
import org.btsoft.jf.cloud.security.permission.vo.PermissionVO;
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
 * @author chenbin
 * @date 2018-12-07 19:28
 */
@RestController
@RequestMapping("/security/permission")
@JResource(code = "permission", descCN = "权限点管理", descEN = "Permission Mgt")
public class PermissionController {

	@Autowired
	private IPermissionService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建权限点", descEN = "Create Permission")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid PermissionAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个权限点", descEN = "Find Single Permission")
	public CommonResult<PermissionVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新权限点", descEN = "Update Permission")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid PermissionUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除权限点", descEN = "Delete Permission")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除权限点", descEN = "Batch Delete Permission")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<PermissionDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "权限点列表", descEN = "Permission List")
	public CommonResult<PageResult<PermissionVO>> findPageList(@RequestBody PermissionQueryDTO dto) {
		return service.findPageList(dto);
	}

	@PutMapping(ControllerContants.Path.SYNC)
	@JOperator(code = ControllerContants.Operator.SYNC, descCN = "同步权限", descEN = "Sync Permission")
	@JAuditLog
	public CommonResult<Integer> sysnPermission(@RequestBody PermissionSyncDTO dto) {
		return service.sysnPermission(dto);
	}
	
	@PostMapping("/list/tree")
	@JOperator(code = "trer", descCN = "权限树", descEN = "Permission Tree")
	public CommonResult<List<Map<String, Object>>> findPermissionTree(@RequestBody PermissionQueryDTO dto){
		return service.findPermissionTree(dto);
	}

}
