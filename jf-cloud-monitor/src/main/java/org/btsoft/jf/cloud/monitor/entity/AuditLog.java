package org.btsoft.jf.cloud.monitor.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chenbin
 * @date 2018年6月15日 下午11:20:05
 */
public class AuditLog implements Serializable {

	private static final long serialVersionUID = -8276107897494520063L;

	private Long logId;

	private Date logTime;

	private String logAccount;

	private String logIp;

	private String logHost;

	private String logFullName;

	private String logModul;

	private String logMethod;

	private String logMessage;

	private Date logStartTime;
	
	private Date logEndTime;

	private Long logCost;

	private String logUrl;

	private String logClient;

	private String logType;
	
	private String appCode;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

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

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLogHost() {
		return logHost;
	}

	public void setLogHost(String logHost) {
		this.logHost = logHost;
	}

	public String getLogFullName() {
		return logFullName;
	}

	public void setLogFullName(String logFullName) {
		this.logFullName = logFullName;
	}

	public String getLogModul() {
		return logModul;
	}

	public void setLogModul(String logModul) {
		this.logModul = logModul;
	}

	public String getLogMethod() {
		return logMethod;
	}

	public void setLogMethod(String logMethod) {
		this.logMethod = logMethod;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public Date getLogStartTime() {
		return logStartTime;
	}

	public void setLogStartTime(Date logStartTime) {
		this.logStartTime = logStartTime;
	}

	public Date getLogEndTime() {
		return logEndTime;
	}

	public void setLogEndTime(Date logEndTime) {
		this.logEndTime = logEndTime;
	}

	public Long getLogCost() {
		return logCost;
	}

	public void setLogCost(Long logCost) {
		this.logCost = logCost;
	}

	public String getLogUrl() {
		return logUrl;
	}

	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}

	public String getLogClient() {
		return logClient;
	}

	public void setLogClient(String logClient) {
		this.logClient = logClient;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
}
