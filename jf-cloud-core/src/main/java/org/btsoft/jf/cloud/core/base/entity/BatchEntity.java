package org.btsoft.jf.cloud.core.base.entity;

import java.io.Serializable;
import java.util.List;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;

/**
 *  批量操作实体类
 * @author chenbin
 * @date 2018-11-29 22:42
 */
public class BatchEntity<T> implements Serializable {

	private static final long serialVersionUID = -82286152892344133L;
	
	/**
	 * 当前用户id
	 */
	private Long currentUserId;
	
	private List<T> list;
	
	public Long getCurrentUserId() {
		if (this.currentUserId == null) {
			RequestContext rc = RequestContext.getCurrent();
			UserInfo user = rc.getUser();
			this.currentUserId = user.getUserId();
		}
		return this.currentUserId;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
