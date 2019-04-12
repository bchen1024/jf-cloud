package org.btsoft.jf.cloud.security.user.service;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.user.dto.UserAddDTO;
import org.btsoft.jf.cloud.security.user.dto.UserQueryDTO;
import org.btsoft.jf.cloud.security.user.entity.User;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:40:39
 */
public interface IUserService{
	
	/**
	 * 根据用户id获取用户列表
	 * @param userIdList
	 * @return
	 */
	CommonResult<List<UserInfo>> findUserListByUserId(List<Long> userIdList);
	
	/**
	 * 根据用户id获取用户map
	 * @param userIdList
	 * @return
	 */
	CommonResult<Map<Long, UserInfo>> findUserMapByUserId(List<Long> userIdList);
	
	/**
	 * 用户分页查询
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018年11月17日 下午11:52:45
	 */
	CommonResult<PageResult<UserInfo>> findPageList(UserQueryDTO dto);
	
	/**
	 * 根据账号获取用户信息
	 * @param userAccount
	 * @return
	 * @autor chenbin
	 * @date 2018年11月19日 下午11:08:09
	 */
	User findUserByAccount(String userAccount);
	
	/**
	 * 创建用户
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-01 09:06
	 */
	CommonResult<Integer> createSingle(UserAddDTO dto);
}
