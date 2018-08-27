package org.btsoft.jf.cloud.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.context.RequestUser;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.mapper.IUserMapper;
import org.btsoft.jf.cloud.security.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author chenbin
 * @date 2018年7月2日 下午10:29:13
 */
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private RestTemplate rest;

	@Override
	public int createSingle(UserInfo t) {
		return mapper.createSingle(t);
	}

	@Override
	public UserInfo findSingle(UserInfo t) {
		return mapper.findSingle(t);
	}

	@Override
	public int updateSingle(UserInfo t) {
		return mapper.updateSingle(t);
	}

	@Override
	public int deleteSingle(UserInfo t) {
		return mapper.deleteSingle(t);
	}

	@Override
	public int deleteMultiple(List<UserInfo> t) {
		if(!CollectionUtils.isEmpty(t)){
			return mapper.deleteMultiple(t);
		}
		return 0;
	}

	@Override
	public PageResult<UserInfo> findPageList(UserInfo t, PageDTO pageDTO) {
		PageHelper.startPage(pageDTO.getCurPage(), pageDTO.getPageSize());
		List<UserInfo> result = mapper.findPageList(t);
		return PageResultUtils.toPageResult(result, pageDTO);
	}

	@Override
	public RequestUser findUser(String token) {
		Map<String,Object> userTokenDTO=new HashMap<String,Object>();
		userTokenDTO.put("token", token);
		HttpEntity<Map<String,Object>> requestEntity=new HttpEntity<Map<String,Object>>(userTokenDTO);
		ResponseEntity<String> rn=rest.exchange("http://jf-cloud-sso/sso/auth/user", HttpMethod.POST, 
				requestEntity, String.class);
		String crStr=rn.getBody();
		CommonResult<UserInfo> cr=(CommonResult<UserInfo>)JSON.parseObject(crStr, new TypeReference<CommonResult<UserInfo>>(){});
		UserInfo userInfo=cr.getData();
		RequestUser user=new RequestUser();
		BeanUtils.copyProperties(userInfo, user);
		return user;
	}

}
