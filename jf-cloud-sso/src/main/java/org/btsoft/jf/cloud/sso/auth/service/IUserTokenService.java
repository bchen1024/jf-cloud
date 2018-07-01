package org.btsoft.jf.cloud.sso.auth.service;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午10:06:20
 */
public interface IUserTokenService {
	
	UserInfo findUserByToken(UserToken userToken);
	
	int deleteUserToken(UserToken userToken); 
}
