package org.btsoft.jf.cloud.config.property.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:04:04
 */
public class PropertyDeleteDTO extends AppDTO {

	private static final long serialVersionUID = -3700790301824727736L;
	
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
