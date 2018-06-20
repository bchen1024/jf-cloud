package org.btsoft.jf.cloud.security.entity;

import java.util.Date;

import org.btsoft.jf.cloud.core.base.entity.BaseEntity;

/**
 * 
 * @author chenbin
 * @date 2018年6月20日 下午10:37:19
 */
public class Relation extends BaseEntity {

	private static final long serialVersionUID = 2408904419955007687L;
	
	private Long id;
	
	private Long masterId;
	
	private Long relationId;
	
	private String relationType;
	
	private Date beginDate;
	
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
