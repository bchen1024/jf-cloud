package org.btsoft.jf.cloud.sso.auth.service.impl;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;
import org.btsoft.jf.cloud.sso.auth.mapper.IUserTokenMapper;
import org.btsoft.jf.cloud.sso.auth.service.IUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午10:07:13
 */
@Service
public class UserTokenService implements IUserTokenService {
	
	@Autowired
	private IUserTokenMapper mapper;

	@Override
	public UserInfo findUserByToken(UserToken userToken) {
		return mapper.findUserByToken(userToken);
	}

	@Override
	public int deleteUserToken(UserToken userToken) {
		return mapper.deleteUserToken(userToken);
	}

}
