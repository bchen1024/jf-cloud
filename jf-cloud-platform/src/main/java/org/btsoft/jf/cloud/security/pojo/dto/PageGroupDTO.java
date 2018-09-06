package org.btsoft.jf.cloud.security.pojo.dto;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午11:23:28
 */
public class PageGroupDTO extends PageDTO {

	private static final long serialVersionUID = 9163517858079875402L;

	private String groupCode;// 群组编码
	private String groupName;// 群组名称

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

}
