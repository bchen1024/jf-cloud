package org.btsoft.jf.cloud.security.web.dto.app;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class DeleteAppDTO extends BaseDTO {

	private static final long serialVersionUID = 7419599270900974420L;

	@NotNull
	private Long appId;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

}
