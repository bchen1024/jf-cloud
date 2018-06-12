package org.btsoft.jf.cloud.config.web.dto.lookup;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:02:54
 */
public class PageLookupDTO extends PageDTO {

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

}
