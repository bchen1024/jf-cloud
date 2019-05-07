package org.btsoft.jf.cloud.security.app.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 应用添加DTO
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class AppAddDTO extends AppDTO {

	private static final long serialVersionUID = -1359927873073984514L;

	/**
	 * 应用名称
	 */
	@NotBlank
	private String appName;

	/**
	 * 应用上下文
	 */
	@NotBlank
	private String appContextPath;

	/**
	 * 应用描述
	 */
	private String appDesc;

	/**
	 * 应用责任人
	 */
	@NotNull
	private Long appOwner;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public String getAppContextPath() {
		return appContextPath;
	}

	public void setAppContextPath(String appContextPath) {
		this.appContextPath = appContextPath;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public Long getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(Long appOwner) {
		this.appOwner = appOwner;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
