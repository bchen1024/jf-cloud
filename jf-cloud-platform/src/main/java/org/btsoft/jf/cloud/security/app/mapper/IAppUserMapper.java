package org.btsoft.jf.cloud.security.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseBatchMapper;
import org.btsoft.jf.cloud.security.app.entity.AppUser;

/**
 * 
 * @author chenbin
 * @date 2018年5月9日 上午12:14:25
 */
@Mapper
public interface IAppUserMapper extends IBaseBatchMapper<AppUser>{
	
	List<Map<String, Object>> findAppListByUser(AppUser appUser);

}
