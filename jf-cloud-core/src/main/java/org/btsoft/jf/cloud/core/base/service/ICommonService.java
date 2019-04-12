package org.btsoft.jf.cloud.core.base.service;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午9:49:42
 */
public interface ICommonService {
	
	/**
	 * 记录操作日志
	 * @param log
	 */
	void auditLog(Map<String, Object> log);
	
	/**
	 * 获取权限点列表
	 * @return
	 * @autor chenbin
	 * @date 2019-03-26 23:29
	 */
	CommonResult<List<Map<String,String>>> listPermission();
	
	/**
	 * 重新加载mybatis
	 * @return
	 */
	CommonResult<String> reloadMapper();
}
