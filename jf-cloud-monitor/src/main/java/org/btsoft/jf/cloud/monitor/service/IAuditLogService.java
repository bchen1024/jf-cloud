package org.btsoft.jf.cloud.monitor.service;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.monitor.entity.AuditLog;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午10:45:03
 */
public interface IAuditLogService{
	
	int createSingle( AuditLog t);

	PageResult<AuditLog> findPageList(AuditLog t,PageDTO pageDTO);

}
