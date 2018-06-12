package org.btsoft.jf.cloud.config.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.Lookup;
import org.btsoft.jf.cloud.config.mapper.ILookupMapper;
import org.btsoft.jf.cloud.config.service.ILookupService;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

@Service
public class LookupService implements ILookupService {

	@Autowired
	private ILookupMapper mapper;

	@Override
	public int createSingle(Lookup lookup) {
		return mapper.createSingle(lookup);
	}

	@Override
	public Lookup findSingle(Lookup lookup) {
		return mapper.findSingle(lookup);
	}

	@Override
	public int updateSingle(Lookup lookup) {
		return mapper.updateSingle(lookup);
	}

	@Override
	public int deleteSingle(Lookup lookup) {
		return mapper.deleteSingle(lookup);
	}

	@Override
	public int deleteMultiple(List<Lookup> lookups) {
		if (!CollectionUtils.isEmpty(lookups)) {
			return mapper.deleteMultiple(lookups);
		}
		return 0;
	}

	@Override
	public PageResult<Lookup> findPageList(Lookup lookup, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<Lookup> result = mapper.findPageList(lookup);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
