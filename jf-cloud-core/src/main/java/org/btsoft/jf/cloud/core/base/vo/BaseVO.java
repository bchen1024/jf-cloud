package org.btsoft.jf.cloud.core.base.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.entity.AuditEntity;

/**
 * @desc 
 * @author chenbin
 * @date 2018年10月21日 下午11:40:48
 */
public class BaseVO extends AuditEntity{

	private static final long serialVersionUID = 5868340340005413923L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
