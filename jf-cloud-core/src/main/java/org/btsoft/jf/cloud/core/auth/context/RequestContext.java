package org.btsoft.jf.cloud.core.auth.context;

import java.io.Serializable;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.exception.ApplicationException;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 上午11:02:08
 */
public class RequestContext implements Serializable {

	private static final long serialVersionUID = -5468587556758530657L;

	private UserInfo user;

	public static RequestContext getCurrent() {
		RequestContext rc=RequestManagement.getCurrent();
		if(rc==null){
			throw new ApplicationException(401, "exception.requestContext.notExists","RequestContext is null");
		}
		return rc; 
	}
	
	public static RequestContext getCurrent(boolean allowNull) {
		return RequestManagement.getCurrent();
	}

	public UserInfo getUser() {
		if (user == null) {
			throw new ApplicationException(401, "exception.user.notExists", "Unable to log in to the current user");
		}
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
