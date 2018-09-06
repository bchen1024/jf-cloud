package org.btsoft.jf.cloud.core.base.service;

import java.util.Collection;
import java.util.List;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.result.CommonResult;

/**
 * 
 * @author chenbin
 * @date 2018年7月5日 下午7:01:51
 */
public interface IUserQueryService {

	CommonResult<UserInfo> findUserByToken(String token);
	
	CommonResult<List<UserInfo>> findUserListById(Collection<Long> userIdList);
}
