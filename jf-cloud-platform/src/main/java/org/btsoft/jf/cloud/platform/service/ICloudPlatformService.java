package org.btsoft.jf.cloud.platform.service;

import org.btsoft.jf.cloud.core.auth.user.RequestContextUser;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.platform.dto.CurrentUserQueryDTO;

/**
 * @author chenbin
 * @date 2018-12-23 00:01
 */
public interface ICloudPlatformService {
	
	/**
	 * 查询当前用户信息
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-23 00:04
	 */
	CommonResult<RequestContextUser> findCurrentUser(CurrentUserQueryDTO dto);

}
