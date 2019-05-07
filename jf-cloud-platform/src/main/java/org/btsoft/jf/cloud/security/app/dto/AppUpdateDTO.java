package org.btsoft.jf.cloud.security.app.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 应用更新DTO
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class AppUpdateDTO extends AppAddDTO {

	private static final long serialVersionUID = 2901990331828940359L;
	
	/**
	 * 应用id
	 */
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
