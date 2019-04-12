package org.btsoft.jf.cloud.config.lookup.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppPageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:02:54
 */
public class LookupQueryDTO extends AppPageDTO {

	private static final long serialVersionUID = -8880822142980782189L;

	private String codeNo;

	private String codeName;

	private String codeType;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
