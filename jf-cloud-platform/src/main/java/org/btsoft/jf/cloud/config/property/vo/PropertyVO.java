/**
 * 
 */
package org.btsoft.jf.cloud.config.property.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.vo.BaseAppVO;

/**
 * @author Administrator
 *
 */
public class PropertyVO extends BaseAppVO {

	private static final long serialVersionUID = 2792731387762275560L;

	/**
	 * 字典主键id
	 */
	private Long propertyId;

	/**
	 * 字典key值
	 */
	private String propertyKey;

	/**
	 * 字典value值
	 */
	private String propertyValue;

	/**
	 * 字段类型
	 */
	private String propertyType;

	/**
	 * 字段描述
	 */
	private String propertyDesc;

	/**
	 * 扩展属性1
	 */
	private String attr1;

	/**
	 * 扩展属性2
	 */
	private String attr2;

	/**
	 * 扩展属性3
	 */
	private String attr3;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

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

	public String getPropertyDesc() {
		return propertyDesc;
	}

	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
