package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.App;
import org.btsoft.jf.cloud.security.mapper.IAppMapper;
import org.btsoft.jf.cloud.security.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

@Service
public class AppService implements IAppService {

	@Autowired
	private IAppMapper mapper;

	@Override
	public int createSingle(App entity) {
		return mapper.createSingle(entity);
	}

	@Override
	public App findSingle(App entity) {
		return mapper.findSingle(entity);
	}

	@Override
	public int updateSingle(App entity) {
		return mapper.updateSingle(entity);
	}

	@Override
	public int deleteSingle(App entity) {
		return mapper.deleteSingle(entity);
	}

	@Override
	public int deleteMultiple(List<App> entitys) {
		if (!CollectionUtils.isEmpty(entitys)) {
			return mapper.deleteMultiple(entitys);
		}
		return 0;
	}

	@Override
	public PageResult<App> findPageList(App entity, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<App> result = mapper.findPageList(entity);
		return PageResultUtils.toPageResult(result, pageDTO);
	}
}
