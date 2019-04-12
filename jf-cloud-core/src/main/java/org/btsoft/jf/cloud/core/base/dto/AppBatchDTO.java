package org.btsoft.jf.cloud.core.base.dto;

/**
 * 应用下批量DTO
 * @author chenbin
 * @date 2019-03-07 22:54
 */
public class AppBatchDTO<T> extends BatchDTO<T> {

	private static final long serialVersionUID = 6667199778963392339L;
	
	private String appCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

}
