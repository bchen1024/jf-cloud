/**
 * 
 */
package org.btsoft.jf.cloud.config.i18n.entity;

import org.btsoft.jf.cloud.core.base.entity.AppEntity;

/**
 * @ClassName I18n
 * @Description 国际化实体类
 * @author bchen
 * @created 2018年4月2日 上午12:16:50
 */
public class I18n extends AppEntity {

	private static final long serialVersionUID = 7023678482125170561L;

	/**
	 * 国际化主键
	 */
	private Long i18nId;

	/**
	 * 国际化key值
	 */
	private String i18nKey;

	/**
	 * 中文值
	 */
	private String i18nCN;

	/**
	 * 英文值
	 */
	private String i18nEN;

	public Long getI18nId() {
		return i18nId;
	}

	public void setI18nId(Long i18nId) {
		this.i18nId = i18nId;
	}

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

}
