package org.btsoft.jf.cloud.security.web.vo.app;

import org.btsoft.jf.cloud.core.base.vo.BaseVO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午10:53:47
 */
public class AppVO extends BaseVO {

	private static final long serialVersionUID = 1082987001974872810L;

	private Long appId;

	private String appName;

	private String appDesc;

	private Long appOwner;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

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
}
