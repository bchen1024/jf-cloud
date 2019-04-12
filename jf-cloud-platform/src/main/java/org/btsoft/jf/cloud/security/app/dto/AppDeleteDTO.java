package org.btsoft.jf.cloud.security.app.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class AppDeleteDTO extends AppDTO {

	private static final long serialVersionUID = 7419599270900974420L;

	@NotNull
	private Long appId;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
