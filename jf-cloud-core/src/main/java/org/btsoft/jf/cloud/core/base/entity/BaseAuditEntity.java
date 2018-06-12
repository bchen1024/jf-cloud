package org.btsoft.jf.cloud.core.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午12:03:28
 */
public class BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1528658339635873492L;
	
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

}
