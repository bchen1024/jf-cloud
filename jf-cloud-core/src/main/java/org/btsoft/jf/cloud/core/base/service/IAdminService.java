package org.btsoft.jf.cloud.core.base.service;

import org.btsoft.jf.cloud.core.base.entity.AuditLog;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午9:49:42
 */
public interface IAdminService {

	/**
	 * 同步系统权限点
	 * @return
	 */
	public int syncPermission();
	
	/**
	 * 记录操作日志
	 * @param log
	 */
	public void auditLog(AuditLog log);
}
