package org.btsoft.jf.cloud.security.permission.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 同步权限DTO对象
 * @author chenbin
 * @date 2018年6月13日 下午10:46:48
 */
public class PermissionSyncDTO extends AppDTO {

	private static final long serialVersionUID = 7168483099560133064L;

	@NotBlank
	private String appContextPath;

	public String getAppContextPath() {
		return appContextPath;
	}

	public void setAppContextPath(String appContextPath) {
		this.appContextPath = appContextPath;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
