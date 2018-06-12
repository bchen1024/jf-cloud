package org.btsoft.jf.cloud.security.web.dto.group;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午10:01:38
 */
public class DeleteGroupDTO extends BaseDTO {

	private static final long serialVersionUID = 7419599270900974420L;

	@NotNull
	private Long groupId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
