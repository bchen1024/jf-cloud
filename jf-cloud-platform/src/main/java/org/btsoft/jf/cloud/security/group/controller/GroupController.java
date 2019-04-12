package org.btsoft.jf.cloud.security.group.controller;

import javax.validation.Valid;

import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.security.group.dto.GroupAddDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupDeleteDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupQueryDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupUpdateDTO;
import org.btsoft.jf.cloud.security.group.service.IGroupService;
import org.btsoft.jf.cloud.security.group.vo.GroupVO;
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
 * 群组信息Controller
 * @author chenbin
 * @date 2018-12-07 19:28
 */
@RestController
@RequestMapping("/security/group")
@JResource(code = "group", descCN = "群组管理", descEN = "Group Mgt")
public class GroupController {

	@Autowired
	private IGroupService service;

	@PostMapping(ControllerContants.Path.CREATE)
	@JOperator(code = ControllerContants.Operator.CREATE, descCN = "创建群组", descEN = "Create Group")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid GroupAddDTO dto) {
		return service.createSingle(dto);
	}

	@GetMapping(ControllerContants.Path.SINGLE_ID)
	@JOperator(code = ControllerContants.Operator.SINGLE, descCN = "查询单个群组", descEN = "Find Single Group")
	public CommonResult<GroupVO> findSingle(@PathVariable("id") Long id) {
		return service.findSingle(id);
	}

	@PutMapping(ControllerContants.Path.UPDATE)
	@JOperator(code = ControllerContants.Operator.UPDATE, descCN = "更新群组", descEN = "Update Group")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid GroupUpdateDTO dto) {
		return service.updateSingle(dto);
	}

	@DeleteMapping(ControllerContants.Path.DELETE_ID)
	@JOperator(code = ControllerContants.Operator.DELETE, descCN = "删除群组", descEN = "Delete Group")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		return service.deleteSingle(id);
	}

	@DeleteMapping(ControllerContants.Path.BATCH_DELETE)
	@JOperator(code = ControllerContants.Operator.BATCH_DELETE, descCN = "批量删除群组", descEN = "Batch Delete Group")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid AppBatchDTO<GroupDeleteDTO> dto) {
		return service.deleteMultiple(dto);
	}

	@PostMapping(ControllerContants.Path.PAGE)
	@JOperator(code = ControllerContants.Operator.PAGE, descCN = "群组列表", descEN = "Group List")
	public CommonResult<PageResult<GroupVO>> findPageList(@RequestBody GroupQueryDTO dto) {
		return service.findPageList(dto);
	}

}
