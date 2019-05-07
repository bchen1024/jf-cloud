package org.btsoft.jf.cloud.security.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.user.RequestContextUser;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.context.JFCloud;
import org.btsoft.jf.cloud.core.exception.ApplicationException;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.DESEncrypt;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.core.util.PinyinUtils;
import org.btsoft.jf.cloud.security.app.entity.AppUser;
import org.btsoft.jf.cloud.security.app.mapper.IAppUserMapper;
import org.btsoft.jf.cloud.security.group.entity.GroupUser;
import org.btsoft.jf.cloud.security.group.mapper.IGroupUserMapper;
import org.btsoft.jf.cloud.security.role.entity.RoleUser;
import org.btsoft.jf.cloud.security.role.mapper.IRolePermissionMapper;
import org.btsoft.jf.cloud.security.role.mapper.IRoleUserMapper;
import org.btsoft.jf.cloud.security.user.dto.CurrentUserQueryDTO;
import org.btsoft.jf.cloud.security.user.dto.UserAddDTO;
import org.btsoft.jf.cloud.security.user.dto.UserQueryDTO;
import org.btsoft.jf.cloud.security.user.entity.User;
import org.btsoft.jf.cloud.security.user.mapper.IUserMapper;
import org.btsoft.jf.cloud.security.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author chenbin
 * @date 2018年6月28日 下午10:42:02
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private SsoAuthProperties ssoAuthProperties;
	
	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private IAppUserMapper appUserMapper;
	
	@Autowired
	private IGroupUserMapper groupUserMapper;
	
	@Autowired
	private IRoleUserMapper roleUserMapper;
	
	@Autowired
	private IRolePermissionMapper rolePermissionMapper;
	
	@Override
	public CommonResult<List<UserInfo>> findUserListByUserId(List<Long> userIdList) {
		List<UserInfo> list=new ArrayList<UserInfo>();
		if(CollectionUtils.isEmpty(userIdList)) {
			return CommonResultUtils.success(list);
		}
		//去重
		Set<Long> userIdSet=new HashSet<Long>();
		userIdSet.addAll(userIdList);
		
		userIdList=new ArrayList<Long>();
		userIdList.addAll(userIdSet);
		List<User> userList=mapper.findUserListByUserId(userIdList);
		list=EntityUtils.dtoToEntityList(userList, UserInfo.class);
		return CommonResultUtils.success(list);
	}

	@Override
	public CommonResult<Map<Long, UserInfo>> findUserMapByUserId(List<Long> userIdList) {
		List<User> userList=mapper.findUserListByUserId(userIdList);
		Map<Long, UserInfo> result=new HashMap<Long, UserInfo>(userList.size());
		if(!CollectionUtils.isEmpty(userList)) {
			userList.forEach(user->{
				UserInfo userInfo=new UserInfo();
				BeanUtils.copyProperties(user, userInfo);
				result.put(user.getUserId(), userInfo);
			});
		}
		return CommonResultUtils.success(result);
	}

	@Override
	public CommonResult<PageResult<UserInfo>> findPageList(UserQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		User user=EntityUtils.copyProperties(dto, User.class);
		List<User> result = mapper.findList(user);
		List<UserInfo> userList=EntityUtils.dtoToEntityList(result, UserInfo.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(userList, dto.getCurPage(), dto.getPageSize()));
	}
	
	@Override
	public User findUserByAccount(String userAccount) {
		//根据帐号获取用户
		User user=new User();
		user.setUserAccount(userAccount);
		user= mapper.findSingle(user);
		
		//帐号不存在
		if(user==null){
			throw new ApplicationException("sso.auth.user.notExists","The user does not exist");
		}else if(user.getLockTime()!=null){
			//用户密码错误被锁定中
			long lockTime=user.getLockTime().getTime();
			long curTime=System.currentTimeMillis();
			long lockDuration=ssoAuthProperties.getLockDuration();
			if(curTime-lockTime<=lockDuration && lockDuration>0){
				//用户属于锁定中，无法登录
				throw new ApplicationException("sso.auth.user.lock",
						String.format("The user is locked for %s seconds",(lockDuration+lockTime-curTime)/1000),new Object[]{(lockDuration+lockTime-curTime)/1000});
			}else{//用户已超过锁定时长，解除锁定
				User updateUser=new User();
				updateUser.setPwdError(0);
				updateUser.setUserId(user.getUserId());
				mapper.patchSingle(updateUser);
			}
		}else if(!"Y".equals(user.getUserStatus())){
			//用户是无效的
			throw new ApplicationException("sso.auth.user.invalid","The user is invalid");
		}
		return user;
	}

	@Override
	public CommonResult<Integer> createSingle(UserAddDTO dto) {
		String userAccount=dto.getUserAccount();
		if(StringUtils.isEmpty(userAccount)) {
			//如果账号为空，根据用户名称自动生成account
			dto.setUserAccount(PinyinUtils.toPinyin(dto.getUserName()));
		}
		
		//校验account是否重复
		
		User user=new User();
		BeanUtils.copyProperties(dto, user);
		String password=DESEncrypt.encrypt(user.getUserAccount());
		user.setPassword(password);
		user.setUserStatus("Y");
		
		//如果是员工，自动生成工号
		if("1".equals(dto.getUserType())) {
			Long maxEmplyeeNo=mapper.findMaxEmplyeeNo();
			if(maxEmplyeeNo==null) {
				user.setEmployeeNo(10000L);
			}else {
				user.setEmployeeNo(maxEmplyeeNo+1);
			}
		}
		return CommonResultUtils.success(mapper.createSingle(user));
	}
	
	@Override
	public CommonResult<RequestContextUser> findCurrentUser(CurrentUserQueryDTO dto) {
		//获取当前登录用户信息
		RequestContext rc=RequestContext.getCurrent();
		UserInfo user= rc.getUser();
		RequestContextUser rcUser=new RequestContextUser();
		rcUser.setUser(user);
		if(user!=null) {
			
			Long userId=user.getUserId();
			//获取当前用户拥有的app列表
			AppUser appUser=new AppUser();
			appUser.setUserId(userId);
			List<Map<String, Object>> appList=appUserMapper.findAppListByUser(appUser);
			rcUser.setAppList(appList);
			
			if(!CollectionUtils.isEmpty(appList)) {
				String curApp=JFCloud.getCurrentAppCode();
				//获取当前用户拥有的群组
				GroupUser groupUser=new GroupUser();
				groupUser.setUserId(userId);
				groupUser.setAppCode(curApp);
				List<Map<String, Object>> groupList=groupUserMapper.findGroupListByUser(groupUser);
				rcUser.setGroupList(groupList);
				
				//获取当前用户的角色
				RoleUser roleUser=new RoleUser();
				roleUser.setUserId(userId);
				roleUser.setAppCode(curApp);
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
