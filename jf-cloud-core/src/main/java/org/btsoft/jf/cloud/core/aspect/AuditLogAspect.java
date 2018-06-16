package org.btsoft.jf.cloud.core.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JAuditModul;
import org.btsoft.jf.cloud.core.base.entity.AuditLog;
import org.btsoft.jf.cloud.core.base.service.IAdminService;
import org.btsoft.jf.cloud.core.context.JFCloud;
import org.btsoft.jf.cloud.core.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/**
 * 审计日志拦截器
 * 
 * @author chenbin
 * @date 2018年6月11日 下午9:19:52
 */
@Component
@Aspect
@Order(Integer.MAX_VALUE)
public class AuditLogAspect {

	private final static Logger logger = LoggerFactory.getLogger(AuditLogAspect.class);
	
	protected static final ThreadLocal<Long> LOCAL_AUDIT = new ThreadLocal<Long>();

	@Autowired
	private IAdminService service;

	@Pointcut("@annotation(org.btsoft.jf.cloud.core.annotation.JAuditLog)")
	public void jAuditLog() {
	}

	@Before("jAuditLog()")
	public void doBefore(JoinPoint joinPoint) {
		LOCAL_AUDIT.set(System.currentTimeMillis());
	}

	@After("jAuditLog()")
	public void doAfter(JoinPoint joinPoint) {
		try {
			logger.debug("Audit log start...");
			Long startTime=LOCAL_AUDIT.get();
			Long endTime=System.currentTimeMillis();
			// 获取拦截的方法
			Signature signature = joinPoint.getSignature();
			MethodSignature methodSignature = (MethodSignature) signature;
			Method targetMethod = methodSignature.getMethod();
			Class<?> clazz = joinPoint.getTarget().getClass();

			String modul = clazz.getSimpleName();
			// 如果存在JAuditModul注解，从注解中获取模块名
			if (clazz.isAnnotationPresent(JAuditModul.class)) {
				// 获取权限编码
				JAuditModul jm = clazz.getAnnotation(JAuditModul.class);
				if (!StringUtils.isEmpty(jm.modul())) {
					modul = jm.modul();
				}
			}

			String type = targetMethod.getName();
			JAuditLog ja = targetMethod.getAnnotation(JAuditLog.class);
			if (!StringUtils.isEmpty(ja.type())) {
				type = ja.type();
			}

			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			AuditLog log = new AuditLog();
			log.setAppCode(JFCloud.getAppCode());
			log.setLogType("audit");
			//审计日期
			log.setLogTime(new Date(startTime));
			log.setLogStartTime(new Date(startTime));
			log.setLogEndTime(new Date(endTime));
			log.setLogAccount("chenbin");
			
			//主机名和ip
			InetAddress inet=RequestUtils.getInetAddress(request);
			if(inet!=null){
				log.setLogIp(inet.getHostAddress());
				log.setLogHost(inet.getHostName());
			}else{
				log.setLogIp("Unknown");
				log.setLogHost("Unknown");
			}
			log.setLogClient(RequestUtils.getClient(request));
			
			log.setLogFullName(clazz.getName()+"."+targetMethod.getName());
			log.setLogModul(modul);
			log.setLogMethod(type);
			log.setLogCost(endTime-startTime);
			log.setLogUrl(request.getRequestURL().toString());
			log.setLogMessage(JSON.toJSONString(joinPoint.getArgs()));
			service.auditLog(log);
		} catch (Exception e) {
			logger.error("audit log is error:"+e.getMessage());
		}
	}

}
