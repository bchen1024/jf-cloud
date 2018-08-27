package org.btsoft.jf.cloud.core.base.service;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.result.CommonResult;

/**
 * 
 * @author chenbin
 * @date 2018年7月5日 下午7:01:51
 */
public interface IUserQueryService {

	CommonResult<UserInfo> findUserByToken(String token);
}
