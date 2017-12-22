package org.btsoft.jf.cloud.core.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public class BaseEntity implements Serializable {

    /**
     * 有效标识
     */
    @Column(name = "enable_flag")
    private String enableFlag;

    /**
     * 创建人id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @Column(name = "creation_date")
    private Date creationDate;

    /**
     * 最后更新人id
     */
    @Column(name = "last_update_id")
    private Long lastUpdateId;

    /**
     * 最后更新时间
     */
    @Column(name = "last_updation_date")
    private Date lastUpdationDate;

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public Date getLastUpdationDate() {
        return lastUpdationDate;
    }

    public void setLastUpdationDate(Date lastUpdationDate) {
        this.lastUpdationDate = lastUpdationDate;
    }
}
