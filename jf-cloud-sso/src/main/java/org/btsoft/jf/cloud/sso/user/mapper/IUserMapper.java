package org.btsoft.jf.cloud.sso.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseMapper;
import org.btsoft.jf.cloud.sso.user.entity.User;

/**
 * 用户管理Mapper接口
 * @author chenbin
 * @date 2018-11-27 23:38
 */
@Mapper
public interface IUserMapper extends IBaseMapper<User>{
	
	/**
	 * 根据用户id集合获取用户列表
	 * @param userIdList
	 * @return
	 * @autor chenbin
	 * @date 2018-11-27 23:39
	 */
	List<User> findUserListByUserId(List<Long> userIdList);
	
}
