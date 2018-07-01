package org.btsoft.jf.cloud.core.auth.context;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 下午3:49:27
 */
public class RequestUser extends UserInfo {

	private static final long serialVersionUID = -7801731578266644268L;

	private List<Map<String, Object>> roleList;

	private List<Map<String, Object>> groupList;

	private List<String> permissionList;

	private List<Map<String, Object>> personalizedList;

	private Map<String, Object> globalPersonalized;

	public List<Map<String, Object>> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Map<String, Object>> roleList) {
		this.roleList = roleList;
	}

	public List<Map<String, Object>> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Map<String, Object>> groupList) {
		this.groupList = groupList;
	}

	public List<String> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}

	public List<Map<String, Object>> getPersonalizedList() {
		return personalizedList;
	}

	public void setPersonalizedList(List<Map<String, Object>> personalizedList) {
		this.personalizedList = personalizedList;
	}

	public Map<String, Object> getGlobalPersonalized() {
		return globalPersonalized;
	}

	public void setGlobalPersonalized(Map<String, Object> globalPersonalized) {
		this.globalPersonalized = globalPersonalized;
	}

}
