package org.btsoft.jf.cloud.sso.user.service.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 安全配置类
 * @author chenbin
 * @date 2018-11-27 23:06
 */
@Component
@ConfigurationProperties(prefix = "sso.auth")
public class SsoAuthProperties {

	/**
	 * 允许密码错误次数，默认5次
	 */
	private int allowPasswordErrorNum = 5;

	/**
	 * 用户锁定时长，单位毫秒，默认是5分钟
	 */
	private long lockDuration = 300000;

	public int getAllowPasswordErrorNum() {
		return allowPasswordErrorNum;
	}

	public void setAllowPasswordErrorNum(int allowPasswordErrorNum) {
		this.allowPasswordErrorNum = allowPasswordErrorNum;
	}

	public long getLockDuration() {
		return lockDuration;
	}

	public void setLockDuration(long lockDuration) {
		this.lockDuration = lockDuration;
	}

}
