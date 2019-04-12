package org.btsoft.jf.cloud.config.lookup.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.vo.BaseAppVO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午10:06:53
 */
public class LookupVO extends BaseAppVO {

	private static final long serialVersionUID = -8668995936108276389L;

	private Long codeId;

	private String codeNo;

	private String codeName;

	private String codeType;

	private String codeParent;

	private String codeDesc;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

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
