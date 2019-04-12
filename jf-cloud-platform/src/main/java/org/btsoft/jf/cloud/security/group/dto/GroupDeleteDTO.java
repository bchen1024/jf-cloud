package org.btsoft.jf.cloud.security.group.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class GroupDeleteDTO extends AppDTO {

	private static final long serialVersionUID = 7419599270900974420L;

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
