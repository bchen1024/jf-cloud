package org.btsoft.jf.cloud.config.pojo.dto;

import javax.validation.constraints.NotNull;

import org.btsoft.jf.cloud.core.base.dto.BaseDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:04:04
 */
public class DeleteLookupDTO extends BaseDTO {

	private static final long serialVersionUID = -3700790301824727736L;

	@NotNull
	private Long codeId;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

}
