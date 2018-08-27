package org.btsoft.jf.cloud.config.web.dto;

import java.io.Serializable;

/**
 * 
 * @author chenbin
 * @date 2018年5月8日 下午11:25:57
 */
public class UserAppDTO implements Serializable {

	private static final long serialVersionUID = 3397771547432341175L;

	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
