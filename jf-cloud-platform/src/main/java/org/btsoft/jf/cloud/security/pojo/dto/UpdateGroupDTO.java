package org.btsoft.jf.cloud.security.pojo.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:14:59
 */
public class UpdateGroupDTO extends AddGroupDTO {

	private static final long serialVersionUID = 2901990331828940359L;

	@NotNull
	private Long groupId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
