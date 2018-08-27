package org.btsoft.jf.cloud.core.auth.context;

import java.io.Serializable;

import org.btsoft.jf.cloud.core.exception.ApplicationException;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午11:02:08
 */
public class RequestContext implements Serializable {

	private static final long serialVersionUID = -5468587556758530657L;

	private RequestUser user;

	public static RequestContext getCurrent() {
		RequestContext rc=RequestManagement.getCurrent();
		if(rc==null){
			throw new ApplicationException(401, "exception.requestContext.notExists","RequestContext is null");
		}
		return rc; 
	}

	public RequestUser getUser() {
		return user;
	}

	public void setUser(RequestUser user) {
		this.user = user;
	}

}
