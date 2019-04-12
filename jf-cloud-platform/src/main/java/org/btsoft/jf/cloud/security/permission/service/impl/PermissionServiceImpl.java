package org.btsoft.jf.cloud.security.permission.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.BatchEntity;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.permission.dto.PermissionAddDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionDeleteDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionQueryDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionSyncDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionUpdateDTO;
import org.btsoft.jf.cloud.security.permission.entity.Permission;
import org.btsoft.jf.cloud.security.permission.mapper.IPermissionMapper;
import org.btsoft.jf.cloud.security.permission.service.IPermissionService;
import org.btsoft.jf.cloud.security.permission.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;

/**
 * @ClassName PermissionService
 * @Description 权限点Service实现类
 * @author bchen
 * @created 2018-4-8 23:35:48
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CommonResult<Integer> createSingle(PermissionAddDTO dto) {
		Permission entity = EntityUtils.copyProperties(dto, Permission.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<PermissionVO> findSingle(Long id) {
		Permission entity = new Permission();
		entity.setPermissionId(id);
		entity = mapper.findSingle(entity);
		PermissionVO vo = EntityUtils.copyProperties(entity, PermissionVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(PermissionUpdateDTO dto) {
		Permission entity = EntityUtils.copyProperties(dto, Permission.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		Permission entity = new Permission();
		entity.setPermissionId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(List<PermissionDeleteDTO> dto) {
		if (!CollectionUtils.isEmpty(dto)) {
			List<Permission> list = EntityUtils.dtoToEntityList(dto, Permission.class);
			BatchEntity<Permission> batch = new BatchEntity<Permission>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<PermissionVO>> findPageList(PermissionQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		Permission entity = EntityUtils.copyProperties(dto, Permission.class);
		List<Permission> result = mapper.findList(entity);
		List<PermissionVO> list = EntityUtils.dtoToEntityList(result, PermissionVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}

	@Override
	public CommonResult<Integer> sysnPermission(PermissionSyncDTO dto) {
		StringBuffer urlSb=new StringBuffer("http://");
		urlSb.append(dto.getAppCode()).append(dto.getAppContextPath()).append("/common/permission/list");
		String result=restTemplate.getForObject(urlSb.toString(), String.class);
		CommonResult<List<Permission>> cr=(CommonResult<List<Permission>>) JSON.parseObject(result,
				new TypeReference<CommonResult<List<Permission>>>() {
				});
		if(!CollectionUtils.isEmpty(cr.getData())) {
			return CommonResultUtils.success(mapper.syncPermission(cr.getData()));
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<List<Map<String, Object>>> findPermissionTree(PermissionQueryDTO dto) {
		Permission entity = EntityUtils.copyProperties(dto, Permission.class);
		List<Permission> list = mapper.findList(entity);
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		if(!CollectionUtils.isEmpty(list)) {
			Set<String> appCodeSet=new HashSet<String>();
			for (Permission permission : list) {
				if(permission.getAppCode()!=null && !appCodeSet.contains(permission.getAppCode())) {
					Map<String, Object> appMap=new HashMap<String, Object>();
					appMap.put("title", permission.getAppCode());
					appMap.put("attribute", permission);
					result.add(appMap);
					appCodeSet.add(permission.getAppCode());
				}
			}
			
			for (Map<String, Object> map : result) {
				for (Permission permission : list) {
					if("resources".equals(permission.getPermissionType()) && map.get("title").toString().equals(permission.getAppCode())) {
						List<Map<String, Object>> children = map.get("children")!=null?(List<Map<String, Object>>)map.get("children"):new ArrayList<Map<String, Object>>();
						Map<String, Object> permissionMap=new HashMap<String, Object>();
						permissionMap.put("title", permission.getPermissionDescCN());
						permissionMap.put("attribute", permission);
						children.add(permissionMap);
						map.put("children", children);
					}
				}
			}
			
			for (Map<String, Object> map : result) {
				List<Map<String, Object>> children = map.get("children")!=null?(List<Map<String, Object>>)map.get("children"):new ArrayList<Map<String, Object>>();
				for (Map<String, Object> childrenMap : children) {
					Permission p=(Permission)childrenMap.get("attribute");
					for (Permission permission : list) {
						if("method".equals(permission.getPermissionType()) && p.getPermissionCode().equals(permission.getParentCode())) {
							List<Map<String, Object>> childrens = childrenMap.get("children")!=null?(List<Map<String, Object>>)childrenMap.get("children"):new ArrayList<Map<String, Object>>();
							Map<String, Object> permissionMap=new HashMap<String, Object>();
							permissionMap.put("title", permission.getPermissionDescCN());
							permissionMap.put("attribute", permission);
							childrens.add(permissionMap);
							childrenMap.put("children", childrens);
						}
					}
				}
			}
		}
		return CommonResultUtils.success(result);
	}
}
