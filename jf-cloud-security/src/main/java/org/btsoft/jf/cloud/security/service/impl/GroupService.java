package org.btsoft.jf.cloud.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.btsoft.jf.cloud.security.entity.Group;
import org.btsoft.jf.cloud.security.mapper.IGroupMapper;
import org.btsoft.jf.cloud.security.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Group createSingle(Group group) {
		mapper.createSingle(group);
		return group;
	}

	@Override
	public Group findSingle(Group group) {
		return mapper.findSingle(group);
	}

	@Override
	public Group updateSingle(Group group) {
		mapper.updateSingle(group);
		return group;
	}

	@Override
	public Group deleteSingle(Group group) {
		Group single = this.findSingle(group);
		if (single != null) {
			mapper.deleteSingle(single);
		}
		return single;
	}

	@Override
	public void deleteMultiple(List<Group> groups) {
		if (groups != null && !groups.isEmpty()) {
			mapper.deleteMultiple(groups);
		}
	}

	@Override
	public List<Group> findList(Group group) {
		return mapper.findList(group);
	}

	@Override
	public PageResult<Group> findPageList(Group group, Page page) {
		int total = mapper.findCount(group);
		List<Group> result = new ArrayList<Group>();
		if (total > 0) {
			result = mapper.findPageList(group, page);
		}
		return new PageResult<Group>(result, page, total);
	}

}
