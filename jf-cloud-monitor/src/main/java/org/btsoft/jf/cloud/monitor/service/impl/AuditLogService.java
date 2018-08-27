package org.btsoft.jf.cloud.monitor.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.entity.AuditLog;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.monitor.mapper.IAuditLogMapper;
import org.btsoft.jf.cloud.monitor.service.IAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午10:45:49
 */
@Service
public class AuditLogService implements IAuditLogService {
	
	@Autowired
	private IAuditLogMapper mapper;

	@Override
	public int createSingle(AuditLog t) {
		return mapper.createSingle(t);
	}

	@Override
	public PageResult<AuditLog> findPageList(AuditLog t, PageDTO pageDTO) {
		System.out.println(RequestContext.getCurrent().getUser().getUserAccount());
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<AuditLog> result = mapper.findPageList(t);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

}
