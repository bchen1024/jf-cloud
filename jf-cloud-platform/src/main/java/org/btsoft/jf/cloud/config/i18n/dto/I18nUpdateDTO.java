package org.btsoft.jf.cloud.config.i18n.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class I18nUpdateDTO extends I18nAddDTO {

	private static final long serialVersionUID = 3192331863590742066L;

	@NotNull
	private Long i18nId;

	public Long getI18nId() {
		return i18nId;
	}

	public void setI18nId(Long i18nId) {
		this.i18nId = i18nId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
