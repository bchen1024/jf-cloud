package org.btsoft.jf.cloud.security.app.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppPageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class AppQueryDTO extends AppPageDTO {

	private static final long serialVersionUID = 9163517858079875402L;

	private String appName;

	private String appDesc;

	private Long appOwner;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public Long getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(Long appOwner) {
		this.appOwner = appOwner;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
