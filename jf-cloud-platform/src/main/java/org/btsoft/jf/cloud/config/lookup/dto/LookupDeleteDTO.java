package org.btsoft.jf.cloud.config.lookup.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:04:04
 */
public class LookupDeleteDTO extends AppDTO {

	private static final long serialVersionUID = -3700790301824727736L;

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
