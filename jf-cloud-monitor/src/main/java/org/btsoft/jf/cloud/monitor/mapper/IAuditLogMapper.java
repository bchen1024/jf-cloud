package org.btsoft.jf.cloud.monitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.core.base.entity.AuditLog;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午10:44:14
 */
@Mapper
public interface IAuditLogMapper {

	int createSingle(@Param("vo") AuditLog t);

	List<AuditLog> findPageList(@Param("vo") AuditLog t);

}
