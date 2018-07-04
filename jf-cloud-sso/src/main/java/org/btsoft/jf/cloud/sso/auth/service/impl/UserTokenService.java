package org.btsoft.jf.cloud.sso.auth.service.impl;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.sso.auth.entity.User;
import org.btsoft.jf.cloud.sso.auth.entity.UserToken;
import org.btsoft.jf.cloud.sso.auth.mapper.IUserTokenMapper;
import org.btsoft.jf.cloud.sso.auth.service.IUserService;
import org.btsoft.jf.cloud.sso.auth.service.IUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

/**
 * 用户Token Service实现
 * @author chenbin
 * @date 2018年7月1日 上午10:07:13
 */
@Service
public class UserTokenService implements IUserTokenService {
	
	/**
	 * jwt密钥
	 */
	@Value("${jf.cloud.sso.signingKey:null}")
	private String signingKey;
	
	@Autowired
	private IUserTokenMapper mapper;
	
	@Autowired
	private IUserService userService;

	@Override
	public UserInfo findUserByToken(UserToken userToken) {
		//解析token信息
		Claims claims=null;
		try {
			claims=DESEncrypt.parseJWT(userToken.getToken(), signingKey);
		} catch (ExpiredJwtException e) {
			throw new ApplicationException("sso.auth.token.expired","Token has expired, please login again");
		}
		
		//根据token获取用户信息
		Object userAccountObj=claims.get("userAccount");
		userToken.setUserAccount(userAccountObj==null?null:userAccountObj.toString());
		UserToken ut=mapper.findUserToken(userToken);
		
		//判断token信息是否正确
		if(ut==null){
			throw new ApplicationException("sso.auth.token.invalid","Invalid token, Check if the token value is correct.");
		}
		//根据帐号获取用户信息
		User user=userService.findUserByAccount(ut.getUserAccount());
		
		//如果密码更新时间晚于等于时间，许重新登录
		if(user.getPwdUpdateTime().after(ut.getCreationDate())){
			throw new ApplicationException("sso.auth.password.updated","User password is updated, please login again");
		}
		UserInfo userInfo=EntityUtils.copyProperties(user, UserInfo.class);
		return userInfo;
	}

	@Override
	public int deleteUserToken(UserToken userToken) {
		return mapper.deleteUserToken(userToken);
	}

}
