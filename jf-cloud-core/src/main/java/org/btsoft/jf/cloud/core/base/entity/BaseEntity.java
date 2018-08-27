package org.btsoft.jf.cloud.core.base.entity;

import java.util.HashMap;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.context.RequestUser;
import org.btsoft.jf.cloud.core.exception.ApplicationException;

public class BaseEntity extends BaseAuditEntity {
	
	private static final long serialVersionUID = -133258962375151449L;

    /**
     * 扩展属性
     */
    private Map<String, Object> attribute = new HashMap<>();

    public Long getCurrentUserId() {
    	RequestContext rc=RequestContext.getCurrent();
    	RequestUser user=rc.getUser();
    	if(user==null){
    		throw new ApplicationException(401, "exception.user.notExists","Unable to log in to the current user");
    	}
    	return user.getUserId();
    }
    
    public String getCurrentLanguage(){
    	return "zh_CN";
    }

	public Map<String, Object> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, Object> attribute) {
		this.attribute = attribute;
	}
    
}
