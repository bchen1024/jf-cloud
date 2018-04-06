package org.btsoft.jf.cloud.config.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;

/**
 * 应用信息实体类
 */
public class AppInfo extends BaseEntity{

	private static final long serialVersionUID = 4006198318536186373L;

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
