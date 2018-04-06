package org.btsoft.jf.cloud.config.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;

/**
 * @ClassName Lookup
 * @Description Lookup管理类
 * @author bchen
 * @created 2018年4月2日 下午7:40:28
 */
public class Lookup extends BaseEntity {

	private static final long serialVersionUID = 5533414778943779229L;

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

}
