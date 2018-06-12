package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.Group;
import org.btsoft.jf.cloud.security.mapper.IGroupMapper;
import org.btsoft.jf.cloud.security.service.IGroupService;
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
public class GroupService implements IGroupService {

	@Autowired
	private IGroupMapper mapper;

	@Override
	public int createSingle(Group group) {
		return mapper.createSingle(group);
	}

	@Override
	public Group findSingle(Group group) {
		return mapper.findSingle(group);
	}

	@Override
	public int updateSingle(Group group) {
		return mapper.updateSingle(group);
	}

	@Override
	public int deleteSingle(Group group) {
		return mapper.deleteSingle(group);
	}

	@Override
	public int deleteMultiple(List<Group> groups) {
		if (!CollectionUtils.isEmpty(groups)) {
			return mapper.deleteMultiple(groups);
		}
		return 0;
	}

	@Override
	public PageResult<Group> findPageList(Group entity, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<Group> result = mapper.findPageList(entity);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
