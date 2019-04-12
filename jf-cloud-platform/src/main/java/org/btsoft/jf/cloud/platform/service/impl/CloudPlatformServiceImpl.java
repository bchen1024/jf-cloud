package org.btsoft.jf.cloud.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.user.RequestContextUser;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.platform.dto.CurrentUserQueryDTO;
import org.btsoft.jf.cloud.platform.service.ICloudPlatformService;
import org.btsoft.jf.cloud.security.app.entity.AppUser;
import org.btsoft.jf.cloud.security.app.mapper.IAppUserMapper;
import org.btsoft.jf.cloud.security.group.entity.GroupUser;
import org.btsoft.jf.cloud.security.group.mapper.IGroupUserMapper;
import org.btsoft.jf.cloud.security.role.entity.RoleUser;
import org.btsoft.jf.cloud.security.role.mapper.IRolePermissionMapper;
import org.btsoft.jf.cloud.security.role.mapper.IRoleUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author chenbin
 * @date 2018-12-23 00:08
 */
@Service
public class CloudPlatformServiceImpl implements ICloudPlatformService {
	
	@Autowired
	private IAppUserMapper appUserMapper;
	
	@Autowired
	private IGroupUserMapper groupUserMapper;
	
	@Autowired
	private IRoleUserMapper roleUserMapper;
	
	@Autowired
	private IRolePermissionMapper rolePermissionMapper;

	@Override
	public CommonResult<RequestContextUser> findCurrentUser(CurrentUserQueryDTO dto) {
		//获取当前登录用户信息
		RequestContext rc=RequestContext.getCurrent();
		UserInfo user= rc.getUser();
		RequestContextUser rcUser=new RequestContextUser();
		rcUser.setUser(user);
		if(user!=null) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			String appCode=request.getHeader("appCode");
			Long userId=user.getUserId();
			//获取当前用户拥有的app列表
			AppUser appUser=new AppUser();
			appUser.setUserId(userId);
			List<Map<String, Object>> appList=appUserMapper.findAppListByUser(appUser);
			rcUser.setAppList(appList);
			
			if(!CollectionUtils.isEmpty(appList)) {
				String curApp=dto.getAppCode();
				boolean appFlag=false;
				for (Map<String, Object> app : appList) {
					if(app.get("appCode").toString().equals(curApp)) {
						appFlag=true;
						break;
					}
				}
				if(!appFlag) {
					curApp=appList.get(0).get("appCode").toString();
				}
				//获取当前用户拥有的群组
				GroupUser groupUser=new GroupUser();
				groupUser.setUserId(userId);
				groupUser.setAppCode(curApp);
				groupUser.getAttributes().put("appCode",appCode);
				List<Map<String, Object>> groupList=groupUserMapper.findGroupListByUser(groupUser);
				rcUser.setGroupList(groupList);
				
				//获取当前用户的角色
				RoleUser roleUser=new RoleUser();
				roleUser.setUserId(userId);
				roleUser.setAppCode(curApp);
				roleUser.getAttributes().put("appCode",appCode);
				List<Map<String, Object>> roleList=roleUserMapper.findRoleListByUser(roleUser);
				rcUser.setRoleList(roleList);
				
				//获取当前用户拥有的权限点
				if(!CollectionUtils.isEmpty(roleList)){
					List<Long> roleIdList=new ArrayList<Long>();
					for (Map<String, Object> roleMap : roleList) {
						roleIdList.add(Long.parseLong(roleMap.get("roleId").toString()));
					}
					List<String> permissionList=rolePermissionMapper.findPermissionListByUser(roleIdList);
					rcUser.setPermissionList(permissionList);
				}
			}
		}
		return CommonResultUtils.success(rcUser);
	}

}
