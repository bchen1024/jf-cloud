package org.btsoft.jf.cloud.core.base.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.entity.AuditEntity;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午9:31:42
 */
public class BaseAppVO extends AuditEntity {

	private static final long serialVersionUID = 5868340340005413923L;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
