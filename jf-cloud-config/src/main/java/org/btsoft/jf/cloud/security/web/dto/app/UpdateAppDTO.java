package org.btsoft.jf.cloud.security.web.dto.app;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class UpdateAppDTO extends AddAppDTO {

	private static final long serialVersionUID = 2901990331828940359L;
	
	@NotNull
	private Long appId;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

}
