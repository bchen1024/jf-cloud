package org.btsoft.jf.cloud.core.auth.context;

import java.io.Serializable;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午11:02:08
 */
public class RequestContext implements Serializable {

	private static final long serialVersionUID = -5468587556758530657L;

	private RequestUser user;

	public static RequestContext getCurrent() {
		return RequestManagement.getCurrent();
	}

	public RequestUser getUser() {
		return user;
	}

	public void setUser(RequestUser user) {
		this.user = user;
	}

}
