package org.btsoft.jf.cloud.core.base.vo;

import java.util.HashMap;
import java.util.Map;

import org.btsoft.jf.cloud.core.base.entity.BaseAuditEntity;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午9:31:42
 */
public class BaseVO extends BaseAuditEntity{

	private static final long serialVersionUID = -6091893742007419951L;
	
	private Map<String,Object> attributes=new HashMap<String,Object>();

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
