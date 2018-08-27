package org.btsoft.jf.cloud.core.base.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.service.IUserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 
 * @author chenbin
 * @date 2018年7月5日 下午7:03:15
 */
@Service
public class UserQueryService implements IUserQueryService {

	@Autowired
	private RestTemplate restTempate;

	@Override
	public CommonResult<UserInfo> findUserByToken(String token) {
		Map<String, Object> userTokenDTO = new HashMap<String, Object>();
		userTokenDTO.put("token", token);
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(userTokenDTO);
		ResponseEntity<String> rn = restTempate.exchange("http://jf-cloud-sso/sso/auth/user", HttpMethod.POST,
				requestEntity, String.class);
		String crStr = rn.getBody();
		CommonResult<UserInfo> result = (CommonResult<UserInfo>) JSON.parseObject(crStr,
				new TypeReference<CommonResult<UserInfo>>() {
				});
		return result;
	}

}
