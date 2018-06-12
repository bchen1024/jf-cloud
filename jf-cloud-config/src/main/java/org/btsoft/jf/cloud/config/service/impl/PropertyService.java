package org.btsoft.jf.cloud.config.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.entity.Property;
import org.btsoft.jf.cloud.config.mapper.IPropertyMapper;
import org.btsoft.jf.cloud.config.service.IPropertyService;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	private IPropertyMapper mapper;

	@Override
	public int createSingle(Property property) {
		return mapper.createSingle(property);
	}

	@Override
	public Property findSingle(Property property) {
		return mapper.findSingle(property);
	}

	@Override
	public int updateSingle(Property property) {

		return mapper.updateSingle(property);
	}

	@Override
	public int deleteSingle(Property property) {
		return mapper.deleteSingle(property);
	}

	@Override
	public int deleteMultiple(List<Property> propertys) {
		if (!CollectionUtils.isEmpty(propertys)) {
			return mapper.deleteMultiple(propertys);
		}
		return 0;
	}

	@Override
	public PageResult<Property> findPageList(Property property, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<Property> result = mapper.findPageList(property);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
