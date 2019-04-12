package org.btsoft.jf.cloud.security.app.entity;

import org.btsoft.jf.cloud.core.base.entity.BaseEntity;

/**
 * 
 * @author chenbin
 * @date 2018年5月9日 上午12:03:54
 */
public class AppUser extends BaseEntity {

	private static final long serialVersionUID = 1207031925756169077L;
	
	private Long id;
	
	private Long userId;
	
	private Long appId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}
}
