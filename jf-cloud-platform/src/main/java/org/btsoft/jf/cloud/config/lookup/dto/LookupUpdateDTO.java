package org.btsoft.jf.cloud.config.lookup.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class LookupUpdateDTO extends LookupAddDTO {

	private static final long serialVersionUID = 3192331863590742066L;

	@NotNull
	private Long codeId;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
