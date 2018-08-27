package org.btsoft.jf.cloud.security.service;

import org.btsoft.jf.cloud.core.auth.context.RequestUser;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.service.IBaseCRUDService;

/**
 * 
 * @author chenbin
 * @date 2018年7月2日 下午10:28:41
 */
public interface IUserService extends IBaseCRUDService<UserInfo>{
	
	RequestUser findUser(String token);

}
