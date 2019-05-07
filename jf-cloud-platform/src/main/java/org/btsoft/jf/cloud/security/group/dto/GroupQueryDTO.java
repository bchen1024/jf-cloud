package org.btsoft.jf.cloud.security.group.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppPageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class GroupQueryDTO extends AppPageDTO {

	private static final long serialVersionUID = 9163517858079875402L;

	/**
	 * 群组编码
	 */
	private String groupCode;
	/**
	 * 群组名称
	 */
	private String groupName;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
