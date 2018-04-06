package org.btsoft.jf.cloud.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.config.entity.Lookup;
import org.btsoft.jf.cloud.config.mapper.ILookupMapper;
import org.btsoft.jf.cloud.config.service.ILookupService;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookupService implements ILookupService {

	@Autowired
	private ILookupMapper mapper;

	@Override
	public Lookup createSingle(Lookup lookup) {
		mapper.createSingle(lookup);
		return lookup;
	}

	@Override
	public Lookup findSingle(Lookup lookup) {
		return mapper.findSingle(lookup);
	}

	@Override
	public Lookup updateSingle(Lookup lookup) {
		mapper.updateSingle(lookup);
		return lookup;
	}

	@Override
	public Lookup deleteSingle(Lookup lookup) {
		Lookup single = this.findSingle(lookup);
		if (single != null) {
			mapper.deleteSingle(single);
		}
		return single;
	}

	@Override
	public void deleteMultiple(List<Lookup> lookups) {
		if (lookups != null && !lookups.isEmpty()) {
			mapper.deleteMultiple(lookups);
		}
	}

	@Override
	public List<Lookup> findList(Lookup lookup) {
		return mapper.findList(lookup);
	}

	@Override
	public PageResult<Lookup> findPageList(Lookup lookup, Page page) {
		int total = mapper.findCount(lookup);
		List<Lookup> result = new ArrayList<Lookup>();
		if (total > 0) {
			result = mapper.findPageList(lookup, page);
		}
		return new PageResult<Lookup>(result, page, total);
	}

}
