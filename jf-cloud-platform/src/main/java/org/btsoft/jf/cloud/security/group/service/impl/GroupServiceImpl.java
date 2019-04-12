package org.btsoft.jf.cloud.security.group.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.BatchEntity;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.group.dto.GroupAddDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupDeleteDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupQueryDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupUpdateDTO;
import org.btsoft.jf.cloud.security.group.entity.Group;
import org.btsoft.jf.cloud.security.group.mapper.IGroupMapper;
import org.btsoft.jf.cloud.security.group.service.IGroupService;
import org.btsoft.jf.cloud.security.group.vo.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * @ClassName GroupService
 * @Description 群组管理Service实现类
 * @author bchen
 * @created 2018年4月3日 下午7:25:05
 */
@Service
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private IGroupMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(GroupAddDTO dto) {
		Group entity = EntityUtils.copyProperties(dto, Group.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<GroupVO> findSingle(Long id) {
		Group entity = new Group();
		entity.setGroupId(id);
		entity = mapper.findSingle(entity);
		GroupVO vo = EntityUtils.copyProperties(entity  , GroupVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(GroupUpdateDTO dto) {
		Group entity = EntityUtils.copyProperties(dto, Group.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		Group entity = new Group();
		entity.setGroupId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<GroupDeleteDTO> dto) {
		List<GroupDeleteDTO> deleteList=dto.getList();
		if (!CollectionUtils.isEmpty(deleteList)) {
			List<Group> list = EntityUtils.dtoToEntityList(deleteList, Group.class);
			BatchEntity<Group> batch = new BatchEntity<Group>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<GroupVO>> findPageList(GroupQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		Group entity = EntityUtils.copyProperties(dto, Group.class);
		List<Group> result = mapper.findList(entity);
		List<GroupVO> list = EntityUtils.dtoToEntityList(result, GroupVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}
}
