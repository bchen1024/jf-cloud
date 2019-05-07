package org.btsoft.jf.cloud.core.auth.user;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author chenbin
 * @date 2018年7月1日 下午3:49:27
 */
public class RequestContextUser implements Serializable {

	private static final long serialVersionUID = -7801731578266644268L;
	
	private UserInfo user;
	
	private List<Map<String, Object>> appList;

	private List<Map<String, Object>> roleList;

	private List<Map<String, Object>> groupList;

	private List<String> permissionList;

	private List<Map<String, Object>> personalizedList;

	private Map<String, Object> globalPersonalized;
	
	private Map<String,Object> env;
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public List<Map<String, Object>> getAppList() {
		return appList;
	}

	public void setAppList(List<Map<String, Object>> appList) {
		this.appList = appList;
	}

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

	public Map<String, Object> getEnv() {
		return env;
	}

	public void setEnv(Map<String, Object> env) {
		this.env = env;
	}

}
