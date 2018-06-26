package org.btsoft.jf.cloud.core.base.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.base.entity.AuditLog;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.service.IAdminService;
import org.btsoft.jf.cloud.core.context.JFCloud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午10:04:31
 */
@Service
public class AdminService implements IAdminService {
	
	@Value("${jf.cloud.cloudPlatformUrl:http://jf-cloud-platform/platform}")
	private String cloudPlatformUrl;
	
	@Value("${jf.cloud.cloudMonitorUrl:http://jf-cloud-monitor/monitor}")
	private String cloudMonitorUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final static Logger logger=LoggerFactory.getLogger(AdminService.class);

	@Override
	public int syncPermission() {
		logger.info("sync permission start...");
		Map<String, Object> resoucesMap = JFCloud.getContent().getBeansWithAnnotation(JResource.class);
		if(resoucesMap!=null){
			List<Map<String,String>> resoucesList=new ArrayList<Map<String,String>>();
			List<Map<String,String>> methodList=new ArrayList<Map<String,String>>();
			for (Iterator<Object> iterator = resoucesMap.values().iterator(); iterator.hasNext();) {
				Object obj = iterator.next();
				Class<?> clazz=AopUtils.getTargetClass(obj);
				if (!clazz.isAnnotationPresent(JResource.class)) {
					continue;
				}
				JResource jr = clazz.getAnnotation(JResource.class);
				
				//构造Resources对象
				Map<String, String> resourceMap=new HashMap<String, String>();
				resourceMap.put("permissionCode", jr.code());
				resourceMap.put("permissionDescCN", jr.descCN());
				resourceMap.put("permissionDescEN", jr.descEN());
				resourceMap.put("permissionType", "resouces");
				resourceMap.put("appCode", JFCloud.getAppCode());
				resoucesList.add(resourceMap);
				
				//获取方法级权限配置
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(JOperator.class)) {
						JOperator jo = method.getAnnotation(JOperator.class);
						Map<String, String> methodMap=new HashMap<String, String>();
						methodMap.put("permissionCode", jo.code());
						methodMap.put("permissionDescCN", jo.descCN());
						methodMap.put("permissionDescEN", jo.descEN());
						methodMap.put("parentCode", jr.code());
						methodMap.put("permissionType", "method");
						methodMap.put("appCode", JFCloud.getAppCode());
						methodList.add(methodMap);
					}
				}
			}
			
			//合并资源和方法权限点
			resoucesList.addAll(methodList);
			if(!CollectionUtils.isEmpty(resoucesList)){
				//调用服务同步权限到数据库
				logger.info(String.format("sync permissionList:%s", JSON.toJSONString(resoucesList)));
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("permissionList", resoucesList);
				restTemplate.put(cloudPlatformUrl+"/security/permission/sync", params);
				return resoucesList.size();
			}
		}
		return 0;
	}

	@Override
	@Async
	public void auditLog(AuditLog log) {
		try {
			restTemplate.postForObject(cloudMonitorUrl+"/auditLog/create", log, CommonResult.class);
		} catch (Exception e) {
			logger.error("Audit log is error:"+e.getMessage());
		}
		
	}

}
