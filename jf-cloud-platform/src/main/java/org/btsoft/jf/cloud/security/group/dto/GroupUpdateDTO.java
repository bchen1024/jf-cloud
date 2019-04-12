package org.btsoft.jf.cloud.security.group.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class GroupUpdateDTO extends GroupAddDTO {

	private static final long serialVersionUID = 2901990331828940359L;

	@NotNull
	private Long groupId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
