package org.btsoft.jf.cloud.security.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;

/**
 * @ClassName Group
 * @Description 用户群组实体类
 * @author bchen
 * @created 2018-4-3 19:09:48
 */
public class Group extends BaseEntity {

	private static final long serialVersionUID = 5033557578139395200L;

	private Long groupId;// 群组id
	private String groupCode;// 群组编码
	private String groupName;// 群组名称
	private String applyStatus;// 是否可申请
	private Long groupOwner;// 群组责任人
	private String groupDesc;// 群组描述

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Long getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(Long groupOwner) {
		this.groupOwner = groupOwner;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
}
