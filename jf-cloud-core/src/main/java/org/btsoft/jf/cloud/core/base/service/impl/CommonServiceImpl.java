package org.btsoft.jf.cloud.core.base.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.service.ICommonService;
import org.btsoft.jf.cloud.core.context.JFCloud;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午10:04:31
 */
@Service
public class CommonServiceImpl implements ICommonService {
	
	@Value("${jf.cloud.cloudPlatformUrl:http://jf-cloud-platform/platform}")
	private String cloudPlatformUrl;
	
	@Value("${jf.cloud.cloudMonitorUrl:http://jf-cloud-monitor/monitor}")
	private String cloudMonitorUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final static Logger logger=LoggerFactory.getLogger(CommonServiceImpl.class);

	@Override
	@Async
	public void auditLog(Map<String, Object> log) {
		try {
			restTemplate.postForObject(cloudMonitorUrl+"/auditLog/create", log, CommonResult.class);
		} catch (Exception e) {
			logger.error("Audit log is error:"+e.getMessage());
		}
	}

	@Override
	public CommonResult<List<Map<String, String>>> listPermission() {
		Map<String, Object> resourcesMap = JFCloud.getContent().getBeansWithAnnotation(JResource.class);
		List<Map<String,String>> resourcesList=new ArrayList<Map<String,String>>();
		if(resourcesMap!=null){
			List<Map<String,String>> methodList=new ArrayList<Map<String,String>>();
			for (Iterator<Object> iterator = resourcesMap.values().iterator(); iterator.hasNext();) {
				Object obj = iterator.next();
				Class<?> clazz=AopUtils.getTargetClass(obj);
				if (!clazz.isAnnotationPresent(JResource.class)) {
					continue;
				}
				JResource jr = clazz.getAnnotation(JResource.class);
				
				//构造Resources对象
				Map<String, String> resourceMap=new HashMap<String, String>(10);
				resourceMap.put("permissionCode", jr.code());
				resourceMap.put("permissionDescCN", jr.descCN());
				resourceMap.put("permissionDescEN", jr.descEN());
				resourceMap.put("permissionType", "resources");
				String appCode=jr.appCode();
				if(StringUtils.isEmpty(appCode)) {
					appCode=JFCloud.getAppCode();
				}
				resourceMap.put("appCode", appCode);
				resourcesList.add(resourceMap);
				
				//获取方法级权限配置
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(JOperator.class)) {
						JOperator jo = method.getAnnotation(JOperator.class);
						Map<String, String> methodMap=new HashMap<String, String>(30);
						methodMap.put("permissionCode", jo.code());
						methodMap.put("permissionDescCN", jo.descCN());
						methodMap.put("permissionDescEN", jo.descEN());
						methodMap.put("parentCode", jr.code());
						methodMap.put("permissionType", "method");
						methodMap.put("appCode", appCode);
						methodList.add(methodMap);
					}
				}
			}
			
			//合并资源和方法权限点
			resourcesList.addAll(methodList);
		}
		return CommonResultUtils.success(resourcesList);
	}

	@Override
	public CommonResult<String> reloadMapper() {
		return null;
	}

}
