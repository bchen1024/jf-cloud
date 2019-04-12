package org.btsoft.jf.cloud.security.auth.service;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.security.auth.dto.LoginDTO;
import org.btsoft.jf.cloud.security.auth.dto.UpdatePasswordDTO;
import org.btsoft.jf.cloud.security.auth.vo.LoginVO;

/**
 * 鉴权Service接口
 * @author chenbin
 * @date 2019-04-10 22:35
 */
public interface IAuthService {
	
	/**
	 * 登录系统 
	 * @param login
	 * @return
	 * @autor chenbin
	 * @date 2018年11月17日 下午11:42:16
	 */
	CommonResult<LoginVO> login(LoginDTO login);
	

	/**
	 *  更新密码
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018年11月17日 下午11:50:29
	 */
	CommonResult<Integer> updatePassword(UpdatePasswordDTO dto);

}
