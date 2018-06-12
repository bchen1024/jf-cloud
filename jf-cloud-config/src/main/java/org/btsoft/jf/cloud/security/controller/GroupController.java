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
import org.btsoft.jf.cloud.security.entity.Group;
import org.btsoft.jf.cloud.security.service.IGroupService;
import org.btsoft.jf.cloud.security.web.dto.group.AddGroupDTO;
import org.btsoft.jf.cloud.security.web.dto.group.DeleteGroupDTO;
import org.btsoft.jf.cloud.security.web.dto.group.PageGroupDTO;
import org.btsoft.jf.cloud.security.web.dto.group.UpdateGroupDTO;
import org.btsoft.jf.cloud.security.web.vo.group.GroupVO;
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
 */
@RestController
@RequestMapping("/security/group")
@JResource(code="group",descCN="群组管理",descEN="Group Mgt")
public class GroupController {

	@Autowired
	private IGroupService service;

	@PostMapping(ControllerContants.PATH.CREATE)
	@JOperator(code=ControllerContants.JOPERATOR.CREATE,descCN="创建群组",descEN="Create Group")
	@JAuditLog
	public CommonResult<Integer> createSingle(@RequestBody @Valid AddGroupDTO t) {
		Group entity = EntityUtils.dtoToEntity(t, Group.class);
		return CommonResultUtils.success(service.createSingle(entity));
	}

	@GetMapping(ControllerContants.PATH.SINGLE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.SINGLE,descCN="查询单个群组",descEN="Find Single Group")
	public CommonResult<GroupVO> findSingle(@PathVariable("id") Long id) {
		Group entity = new Group();
		entity.setGroupId(id);
		Group result = service.findSingle(entity);
		GroupVO vo = EntityUtils.dtoToEntity(result, GroupVO.class);
		return CommonResultUtils.success(vo);
	}

	@PutMapping(ControllerContants.PATH.UPDATE)
	@JOperator(code=ControllerContants.JOPERATOR.UPDATE,descCN="更新群组",descEN="Update Group")
	@JAuditLog
	public CommonResult<Integer> updateSingle(@RequestBody @Valid UpdateGroupDTO t) {
		Group entity = EntityUtils.dtoToEntity(t, Group.class);
		return CommonResultUtils.success(service.updateSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.DELETE_ID)
	@JOperator(code=ControllerContants.JOPERATOR.DELETE,descCN="删除群组",descEN="Delete Group")
	@JAuditLog
	public CommonResult<Integer> deleteSingle(@PathVariable("id") Long id) {
		Group entity = new Group();
		entity.setGroupId(id);
		return CommonResultUtils.success(service.deleteSingle(entity));
	}

	@DeleteMapping(ControllerContants.PATH.BATCH_DELETE)
	@JOperator(code=ControllerContants.JOPERATOR.BATCH_DELETE,descCN="批量删除群组",descEN="Batch Delete Group")
	@JAuditLog
	public CommonResult<Integer> deleteMultiple(@RequestBody @Valid List<DeleteGroupDTO> t) {
		List<Group> appList = EntityUtils.dtoToEntityList(t, Group.class);
		return CommonResultUtils.success(service.deleteMultiple(appList));
	}

	@PostMapping(ControllerContants.PATH.PAGE)
	@JOperator(code=ControllerContants.JOPERATOR.PAGE,descCN="群组列表",descEN="Group List")
	public CommonResult<PageResult<GroupVO>> findPageList(@RequestBody PageGroupDTO t) {
		Group entity = EntityUtils.dtoToEntity(t, Group.class);
		PageDTO pageDTO = EntityUtils.dtoToEntity(t, PageDTO.class);
		PageResult<Group> result = service.findPageList(entity, pageDTO);
		return CommonResultUtils.success(PageResultUtils.entityToVO(GroupVO.class, result));
	}

}
