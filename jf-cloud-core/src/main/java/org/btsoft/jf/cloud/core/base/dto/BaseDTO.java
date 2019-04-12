package org.btsoft.jf.cloud.core.base.dto;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 基类DTO
 * @author chenbin
 * @date 2018-11-27 23:12
 */
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 6254462187229850943L;
	/**
	 * 扩展属性
	 */
	private Map<String, Object> attributes;

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
