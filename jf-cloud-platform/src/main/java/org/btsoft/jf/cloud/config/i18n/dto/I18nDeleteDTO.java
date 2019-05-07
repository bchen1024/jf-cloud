package org.btsoft.jf.cloud.config.i18n.dto;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:04:04
 */
public class I18nDeleteDTO extends AppDTO {

	private static final long serialVersionUID = -3700790301824727736L;

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
