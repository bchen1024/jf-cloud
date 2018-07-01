package org.btsoft.jf.cloud.sso.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;

/**
 * 
 * @author chenbin
 * @date 2018年6月30日 下午11:43:39
 */
@Mapper
public interface IUserTokenMapper {
	
	/**
	 * 创建用户token记录
	 * @param userToken
	 * @return
	 */
	int createUserToken(UserToken userToken);
	
	/**
	 * 根据token获取用户 信息
	 * @param userToken
	 * @return
	 */
	UserInfo findUserByToken(UserToken userToken);
	
	/**
	 * 退出删除用户token记录
	 * @param userToken
	 * @return
	 */
	int deleteUserToken(UserToken userToken);

}
