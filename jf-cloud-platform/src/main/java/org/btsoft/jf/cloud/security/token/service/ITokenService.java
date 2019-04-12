package org.btsoft.jf.cloud.security.token.service;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.auth.dto.LogoutDTO;
import org.btsoft.jf.cloud.security.auth.dto.TokenDTO;
import org.btsoft.jf.cloud.security.token.dto.TokenQueryDTO;
import org.btsoft.jf.cloud.security.token.vo.TokenVO;

/**
 * token管理Service
 * @author chenbin
 * @date 2018-11-27 23:40
 */
public interface ITokenService {

	/**
	 * 分页查询Token列表
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-11-27 23:39
	 */
	CommonResult<PageResult<TokenVO>> findPageList(TokenQueryDTO dto);

	/**
	 * 根据token获取用户
	 * @param userToken
	 * @return
	 */
	CommonResult<UserInfo> findUserByToken(TokenDTO dto);

	/**
	 * 根据token删除的token和用户的关系
	 * 
	 * @param userToken
	 * @return
	 */
	int deleteUserToken(LogoutDTO dto);
}
