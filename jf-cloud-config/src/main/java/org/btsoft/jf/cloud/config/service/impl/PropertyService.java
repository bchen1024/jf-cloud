package org.btsoft.jf.cloud.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.config.entity.Property;
import org.btsoft.jf.cloud.config.mapper.IPropertyMapper;
import org.btsoft.jf.cloud.config.service.IPropertyService;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	private IPropertyMapper mapper;

	@Override
	public Property createSingle(Property property) {
		mapper.createSingle(property);
		return property;
	}

	@Override
	public Property findSingle(Property property) {
		return mapper.findSingle(property);
	}

	@Override
	public Property updateSingle(Property property) {
		mapper.updateSingle(property);
		return property;
	}

	@Override
	public Property deleteSingle(Property Property) {
		Property single = this.findSingle(Property);
		if (single != null) {
			mapper.deleteSingle(single);
		}
		return single;
	}

	@Override
	public void deleteMultiple(List<Property> propertys) {
		if (propertys != null && !propertys.isEmpty()) {
			mapper.deleteMultiple(propertys);
		}
	}

	@Override
	public List<Property> findList(Property property) {
		return mapper.findList(property);
	}

	@Override
	public PageResult<Property> findPageList(Property property, Page page) {
		int total = mapper.findCount(property);
		List<Property> result = new ArrayList<Property>();
		if (total > 0) {
			result = mapper.findPageList(property, page);
		}
		return new PageResult<Property>(result, page, total);
	}

}
