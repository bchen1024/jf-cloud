package org.btsoft.jf.cloud.sso.auth.service;

import org.btsoft.jf.cloud.sso.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.sso.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.sso.auth.entity.User;
import org.btsoft.jf.cloud.sso.auth.vo.LoginVO;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:40:39
 */
public interface IUserService {
	
	User findUserByAccount(String userAccount);

	LoginVO login(LoginDTO login);
	
	int updatePassword(UpdatePasswordDTO dto);
}
