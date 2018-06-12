package org.btsoft.jf.cloud.config.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.I18n;
import org.btsoft.jf.cloud.config.mapper.II18nMapper;
import org.btsoft.jf.cloud.config.service.II18nService;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

@Service
public class I18nService implements II18nService {

	@Autowired
	private II18nMapper mapper;

	@Override
	public int createSingle(I18n i18n) {
		return mapper.createSingle(i18n);
	}

	@Override
	public I18n findSingle(I18n i18n) {
		return mapper.findSingle(i18n);
	}

	@Override
	public int updateSingle(I18n i18n) {
		return mapper.updateSingle(i18n);
	}

	@Override
	public int deleteSingle(I18n i18n) {
		return mapper.deleteSingle(i18n);
	}

	@Override
	public int deleteMultiple(List<I18n> i18ns) {
		if (!CollectionUtils.isEmpty(i18ns)) {
			return mapper.deleteMultiple(i18ns);
		}
		return 0;
	}

	@Override
	public PageResult<I18n> findPageList(I18n i18n, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<I18n> result = mapper.findPageList(i18n);
		return PageResultUtils.toPageResult(result, pageDTO);
	}
}
