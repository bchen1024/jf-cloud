package org.btsoft.jf.cloud.core.base.service;

import java.util.Collection;
import java.util.List;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;

/**
 * 用户查询Service接口
 * @author chenbin
 * @date 2018-11-27 22:59
 */
public interface IUserQueryService { 

	/**
	 * 根据token获取用户
	 * @param token
	 * @return 用户信息
	 * @autor chenbin
	 * @date 2018-11-27 22:59
	 */
	CommonResult<UserInfo> findUserByToken(String token);
	
	/**
	 * 根据用户id获取用户列表
	 * @param userIdList 用户id集合
	 * @return
	 * @autor chenbin
	 * @date 2018-11-27 23:00
	 */
	CommonResult<List<UserInfo>> findUserListById(Collection<Long> userIdList);
}
