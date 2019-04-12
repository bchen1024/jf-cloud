package org.btsoft.jf.cloud.core.base.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 应用分页DTO对象
 * @author chenbin
 * @date 2018-12-07 22:51
 */
public class AppPageDTO extends PageDTO {

	private static final long serialVersionUID = -8263863918732824170L;
	
	private String appCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
