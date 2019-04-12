package org.btsoft.jf.cloud.core.base.entity;

/**
 * 实体基类
 * @author chenbin
 * @date 2018-11-27 22:39
 */
public class AppEntity extends BaseEntity {

	private static final long serialVersionUID = -133258962375151449L;
	
	/**
	 * 应用编码
	 */
	private String appCode;
	
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

}
