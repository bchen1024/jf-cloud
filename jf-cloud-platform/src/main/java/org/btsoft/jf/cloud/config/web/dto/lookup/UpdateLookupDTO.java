package org.btsoft.jf.cloud.config.web.dto.lookup;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class UpdateLookupDTO extends AddLookupDTO {

	private static final long serialVersionUID = 3192331863590742066L;

	@NotNull
	private Long codeId;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

}
