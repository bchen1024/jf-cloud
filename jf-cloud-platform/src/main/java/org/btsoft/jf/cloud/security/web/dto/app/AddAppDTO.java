package org.btsoft.jf.cloud.security.web.dto.app;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class AddAppDTO extends BaseDTO {

	private static final long serialVersionUID = -1359927873073984514L;
	
	/**
	 * 应用code
	 */
	@NotBlank
	private String appCode;

	@NotBlank
	private String appName;

	private String appDesc;

	@NotNull
	private Long appOwner;
	
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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
}
