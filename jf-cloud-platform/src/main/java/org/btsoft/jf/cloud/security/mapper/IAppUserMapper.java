package org.btsoft.jf.cloud.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;
import org.btsoft.jf.cloud.security.entity.AppUser;

/**
 * 
 * @author chenbin
 * @date 2018年5月9日 上午12:14:25
 */
@Mapper
public interface IAppUserMapper extends IBaseCRUDMapper<AppUser> {

}
