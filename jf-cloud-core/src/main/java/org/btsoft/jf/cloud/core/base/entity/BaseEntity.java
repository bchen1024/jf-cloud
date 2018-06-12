package org.btsoft.jf.cloud.core.base.entity;

import java.util.HashMap;
import java.util.Map;

public class BaseEntity extends BaseAuditEntity {
	
	private static final long serialVersionUID = -133258962375151449L;

    /**
     * 扩展属性
     */
    private Map<String, Object> attribute = new HashMap<>();

    public Long getCurrentUserId() {
        return 1L;
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
