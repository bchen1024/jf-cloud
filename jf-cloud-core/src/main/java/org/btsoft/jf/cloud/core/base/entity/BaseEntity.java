package org.btsoft.jf.cloud.core.base.entity;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 实体基类
 * @author chenbin
 * @date 2018-11-27 22:39
 */
@JsonIgnoreProperties(value= {"currentUserId","currentLanguage"})
public class BaseEntity extends AuditEntity {

	private static final long serialVersionUID = -133258962375151449L;
	
	/**
	 * 当前用户id
	 */
	private Long currentUserId;
	
	private String currentLanguage;

	public Long getCurrentUserId() {
		if (this.currentUserId == null) {
			RequestContext rc = RequestContext.getCurrent();
			UserInfo user = rc.getUser();
			this.currentUserId = user.getUserId();
		}
		return this.currentUserId;
	}

	public String getCurrentLanguage() {
		this.currentLanguage="zh_CN";
		return currentLanguage;
	}

}
