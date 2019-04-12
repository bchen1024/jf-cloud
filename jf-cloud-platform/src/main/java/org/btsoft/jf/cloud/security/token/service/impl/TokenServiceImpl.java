package org.btsoft.jf.cloud.security.token.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.auth.dto.LogoutDTO;
import org.btsoft.jf.cloud.security.auth.dto.TokenDTO;
import org.btsoft.jf.cloud.security.token.dto.TokenQueryDTO;
import org.btsoft.jf.cloud.security.token.entity.Token;
import org.btsoft.jf.cloud.security.token.mapper.ITokenMapper;
import org.btsoft.jf.cloud.security.token.service.ITokenService;
import org.btsoft.jf.cloud.security.token.vo.TokenVO;
import org.btsoft.jf.cloud.security.user.entity.User;
import org.btsoft.jf.cloud.security.user.service.IUserService;
import org.btsoft.jf.cloud.security.user.service.impl.SsoAuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

/**
 * 用户Token Service实现
 * @author chenbin
 * @date 2018年7月1日 上午10:07:13
 */
@Service
public class TokenServiceImpl implements ITokenService {
	
	@Autowired
	private ITokenMapper mapper;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private SsoAuthProperties ssoAuthProperties;
	
	@Override
	public CommonResult<PageResult<TokenVO>> findPageList(TokenQueryDTO dto) {
		Token userToken=EntityUtils.copyProperties(dto, Token.class);
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		List<Token> result = mapper.findList(userToken);
		List<TokenVO> voList=EntityUtils.dtoToEntityList(result, TokenVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(voList, dto.getCurPage(), dto.getPageSize()));
	}

	@Override
	public CommonResult<UserInfo> findUserByToken(TokenDTO dto) {
		Token token=EntityUtils.copyProperties(dto, Token.class);
		//解析token信息
		Claims claims=null;
		try {
			claims=DESEncrypt.parseJWT(token.getToken(), ssoAuthProperties.getSigningKey());
		} catch (ExpiredJwtException e) {
			throw new ApplicationException("sso.auth.token.expired","Token has expired, please login again");
		}
		
		//根据token获取用户信息
		Object userAccountObj=claims.get("userAccount");
		token.setUserAccount(userAccountObj==null?null:userAccountObj.toString());
		Token ut=mapper.findSingle(token);
		
		//判断token信息是否正确
		if(ut==null){
			throw new ApplicationException("sso.auth.token.invalid","Invalid token, Check if the token value is correct.");
		}
		//根据帐号获取用户信息
		User user=userService.findUserByAccount(ut.getUserAccount());
		
		//如果密码更新时间晚于等于时间，许重新登录
		if(user.getPwdUpdateTime()!=null && user.getPwdUpdateTime().after(ut.getCreationDate())){
			throw new ApplicationException("sso.auth.password.updated","User password is updated, please login again");
		}
		UserInfo userInfo=EntityUtils.copyProperties(user, UserInfo.class);
		return CommonResultUtils.success(userInfo);
	}

	@Override
	public int deleteUserToken(LogoutDTO dto) {
		Token token=EntityUtils.copyProperties(dto, Token.class);
		return mapper.deleteSingle(token);
	}

}
