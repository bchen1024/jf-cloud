package org.btsoft.jf.cloud.security.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.entity.AppUser;
import org.btsoft.jf.cloud.security.mapper.IAppUserMapper;
import org.btsoft.jf.cloud.security.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author chenbin
 * @date 2018年5月9日 下午11:12:27
 */
@Service
public class UserAppService implements IUserAppService {

	@Autowired
	private IAppUserMapper mapper;

	@Override
	public int createSingle(AppUser t) {
		return mapper.createSingle(t);
	}

	@Override
	public AppUser findSingle(AppUser t) {
		return mapper.findSingle(t);
	}

	@Override
	public int updateSingle(AppUser t) {
		return mapper.updateSingle(t);
	}

	@Override
	public int deleteSingle(AppUser t) {
		return mapper.deleteSingle(t);
	}

	@Override
	public int deleteMultiple(List<AppUser> t) {
		if (!CollectionUtils.isEmpty(t)) {
			return mapper.deleteMultiple(t);
		}
		return 0;
	}

	@Override
	public PageResult<AppUser> findPageList(AppUser t, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<AppUser> result = mapper.findPageList(t);
		return PageResultUtils.toPageResult(result, pageDTO);
	}
}
