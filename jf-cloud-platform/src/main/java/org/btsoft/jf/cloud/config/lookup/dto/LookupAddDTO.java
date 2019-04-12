package org.btsoft.jf.cloud.config.lookup.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午8:47:25
 */
public class LookupAddDTO extends AppDTO {

	private static final long serialVersionUID = 6875683856420764274L;

	@NotBlank
	private String codeNo;

	@NotBlank
	private String codeName;

	@NotBlank
	private String codeType;

	private String codeParent;

	private String codeDesc;

	public String getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeParent() {
		return codeParent;
	}

	public void setCodeParent(String codeParent) {
		this.codeParent = codeParent;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
