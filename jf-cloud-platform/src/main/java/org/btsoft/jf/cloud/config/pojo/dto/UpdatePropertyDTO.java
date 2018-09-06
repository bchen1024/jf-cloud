package org.btsoft.jf.cloud.config.pojo.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class UpdatePropertyDTO extends AddPropertyDTO {

	private static final long serialVersionUID = 3192331863590742066L;
	
	@NotNull
	private Long propertyId;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

}
