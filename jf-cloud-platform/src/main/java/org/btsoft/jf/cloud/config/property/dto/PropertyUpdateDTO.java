package org.btsoft.jf.cloud.config.property.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class PropertyUpdateDTO extends PropertyAddDTO {

	private static final long serialVersionUID = 3192331863590742066L;
	
	@NotNull
	private Long propertyId;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
