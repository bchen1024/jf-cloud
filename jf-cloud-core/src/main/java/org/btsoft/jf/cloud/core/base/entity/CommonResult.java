package org.btsoft.jf.cloud.core.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用结果对象
 * 
 * @author chenbin
 * @date 2018年6月7日 上午12:01:58
 */
public class CommonResult<T> implements Serializable {

	private static final long serialVersionUID = -1589726208004411730L;

	private int httpCode = 200;
	
	private boolean useI18n=false;

	private String errorCode="common.success";

	private String errorMsg="success";

	private Object[] args;
	
	private Date sysDate;

	private T data;

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
	public boolean isUseI18n() {
		return useI18n;
	}

	public void setUseI18n(boolean useI18n) {
		this.useI18n = useI18n;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Date getSysDate() {
		sysDate = new Date();
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
}
