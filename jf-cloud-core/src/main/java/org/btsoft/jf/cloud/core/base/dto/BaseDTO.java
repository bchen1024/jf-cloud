package org.btsoft.jf.cloud.core.base.dto;

import java.io.Serializable;

/**
 * DTO基类
 * @author chenbin 
 * @date  2018年4月23日 下午9:59:28
 */
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -4452264313603052992L;
	/**
	 * 应用code
	 */
	private String appCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

}
