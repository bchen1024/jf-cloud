package org.btsoft.jf.cloud.monitor.web.dto;

import java.util.Date;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午11:49:12
 */
public class PageAuditLogDTO extends PageDTO {
	
	private static final long serialVersionUID = 1388219275304269380L;

	private Date logTime;

	private String logAccount;
	
	private String logUrl;

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getLogAccount() {
		return logAccount;
	}

	public void setLogAccount(String logAccount) {
		this.logAccount = logAccount;
	}

	public String getLogUrl() {
		return logUrl;
	}

	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}
	
}
