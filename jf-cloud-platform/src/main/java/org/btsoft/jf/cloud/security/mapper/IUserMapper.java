package org.btsoft.jf.cloud.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;

/**
 * 
 * @author chenbin
 * @date 2018年7月2日 下午9:54:35
 */
@Mapper
public interface IUserMapper extends IBaseCRUDMapper<UserInfo>{

}
