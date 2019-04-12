package org.btsoft.jf.cloud.core.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 基础审计字段
 * @author chenbin
 * @date 2018-11-27 22:40
 */
public class AuditEntity implements Serializable {

	private static final long serialVersionUID = -7263026626248400201L;

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
	 * 扩展属性
	 */
	private Map<String, Object> attributes=new HashMap<String, Object>();

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

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
