package org.btsoft.jf.cloud.config.web.dto.i18n;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author chenbin
 * @date 2018年6月12日 下午9:01:44
 */
public class UpdateI18nDTO extends AddI18nDTO {

	private static final long serialVersionUID = 3192331863590742066L;
	
	@NotNull
	private Long i18nId;

	public Long getI18nId() {
		return i18nId;
	}

	public void setI18nId(Long i18nId) {
		this.i18nId = i18nId;
	}

}
