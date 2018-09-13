package org.btsoft.jf.cloud.sso.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.sso.auth.entity.User;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:19:36
 */
@Mapper
public interface IUserMapper {

	/**
	 * 根据帐号获取用户信息
	 * @param user
	 * @return
	 */
	User findUserByAccount(User user);
	
	/**
	 * 更新密码
	 * @param user
	 * @return
	 */
	int updatePassword(User user);
	
	/**
	 * 更新密码错误次数和锁定时间
	 * @param user
	 * @return
	 */
	int updateUserPwdErrorAndLockTime(User user);
	
	/**
	 * 根据用户id获取用户列表
	 * @param userIdSet
	 * @return
	 */
	List<User> findUserListById(List<Long> userIdList);
	
}
