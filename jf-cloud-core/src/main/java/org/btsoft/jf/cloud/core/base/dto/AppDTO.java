package org.btsoft.jf.cloud.core.base.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * DTO基类
 * 
 * @author chenbin
 * @date 2018年4月23日 下午9:59:28
 */
public class AppDTO extends BaseDTO {

	private static final long serialVersionUID = -4046830036448852377L;
	/**
	 * 应用code
	 */
	@NotBlank
	private String appCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
