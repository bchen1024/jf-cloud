package org.btsoft.jf.cloud.security.group.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class GroupAddDTO extends AppDTO {

	private static final long serialVersionUID = -1359927873073984514L;

	/**
	 * 群组编码
	 */
	@NotBlank
	private String groupCode;
	/**
	 * 群组名称
	 */
	@NotBlank
	private String groupName;
	/**
	 * 是否可申请
	 */
	@NotBlank
	private String applyStatus;
	/**
	 * 群组责任人
	 */
	@NotNull
	private Long groupOwner;
	/**
	 * 群组描述
	 */
	private String groupDesc;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
