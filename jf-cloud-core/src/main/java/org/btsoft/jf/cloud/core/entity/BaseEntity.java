package org.btsoft.jf.cloud.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -133258962375151449L;

	/**
     * 有效标识
     */
    private String enableFlag;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 最后更新人id
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdationDate;

    /**
     * 应用编码
     */
    private String appCode;
    
    /**
     * 扩展属性
     */
    private Map<String, Object> attribute = new HashMap<>();

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdationDate() {
        return lastUpdationDate;
    }

    public void setLastUpdationDate(Date lastUpdationDate) {
        this.lastUpdationDate = lastUpdationDate;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getCurrentUserId() {
        return -1L;
    }
    
    public String getCurrentLanguage(){
    	return "zh_CN";
    }

	public Map<String, Object> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, Object> attribute) {
		this.attribute = attribute;
	}
    
}
