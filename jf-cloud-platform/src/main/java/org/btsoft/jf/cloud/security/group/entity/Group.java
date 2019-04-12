package org.btsoft.jf.cloud.security.group.entity;

import org.btsoft.jf.cloud.core.base.entity.AppEntity;

/**
 * @ClassName Group
 * @Description 用户群组实体类
 * @author bchen
 * @created 2018-4-3 19:09:48
 */
public class Group extends AppEntity {

	private static final long serialVersionUID = 5033557578139395200L;

	/**
	 * 群组id
	 */
	private Long groupId;
	/**
	 * 群组编码
	 */
	private String groupCode;
	/**
	 * 群组名称
	 */
	private String groupName;
	/**
	 * 是否可申请
	 */
	private String applyStatus;
	/**
	 * 群组责任人
	 */
	private Long groupOwner;
	/**
	 * 群组描述
	 */
	private String groupDesc;

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
