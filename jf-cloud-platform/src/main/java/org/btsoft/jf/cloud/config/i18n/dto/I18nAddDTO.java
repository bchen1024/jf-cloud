package org.btsoft.jf.cloud.config.i18n.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午8:47:25
 */
public class I18nAddDTO extends AppDTO {

	private static final long serialVersionUID = 6875683856420764274L;

	@NotBlank
	private String i18nKey;

	@NotBlank
	private String i18nCN;

	@NotBlank
	private String i18nEN;

	public String getI18nKey() {
		return i18nKey;
	}

	public void setI18nKey(String i18nKey) {
		this.i18nKey = i18nKey;
	}

	public String getI18nCN() {
		return i18nCN;
	}

	public void setI18nCN(String i18nCN) {
		this.i18nCN = i18nCN;
	}

	public String getI18nEN() {
		return i18nEN;
	}

	public void setI18nEN(String i18nEN) {
		this.i18nEN = i18nEN;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
