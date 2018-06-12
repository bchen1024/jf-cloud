package org.btsoft.jf.cloud.config.web.dto.property;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:02:54
 */
public class PagePropertyDTO extends PageDTO {

	private static final long serialVersionUID = -8880822142980782189L;

	private String propertyKey;

	/**
	 * 字典value值
	 */
	private String propertyValue;

	/**
	 * 字段类型
	 */
	private String propertyType;

	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

}
