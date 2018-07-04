package org.btsoft.jf.cloud.sso.auth.service;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;

/**
 * 用户Token Service接口
 * @author chenbin
 * @date 2018年7月1日 上午10:06:20
 */
public interface IUserTokenService {
	
	/**
	 * 根据token获取用户新
	 * @param userToken
	 * @return
	 */
	UserInfo findUserByToken(UserToken userToken);
	
	/**
	 * 根据token删除的token和用户的关系
	 * @param userToken
	 * @return
	 */
	int deleteUserToken(UserToken userToken); 
}
