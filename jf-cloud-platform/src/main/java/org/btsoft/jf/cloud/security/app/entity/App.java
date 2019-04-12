package org.btsoft.jf.cloud.security.app.entity;

import org.btsoft.jf.cloud.core.base.entity.AppEntity;


/**
 * 应用实体类
 * @author chenbin
 * @date 2018-12-07 19:29
 */
public class App extends AppEntity{

	private static final long serialVersionUID = 4006198318536186373L;

	private Long appId;

    private String appName;
    
    private String appContextPath;

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
    
    public String getAppContextPath() {
		return appContextPath;
	}

	public void setAppContextPath(String appContextPath) {
		this.appContextPath = appContextPath;
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
