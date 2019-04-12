package org.btsoft.jf.cloud.core.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import org.btsoft.jf.cloud.core.base.service.ICommonService;
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
	private ICommonService service;

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
			LOCAL_AUDIT.remove();
			Long endTime=System.currentTimeMillis();
			// 获取拦截的方法
			Signature signature = joinPoint.getSignature();
			MethodSignature methodSignature = (MethodSignature) signature;
			Method targetMethod = methodSignature.getMethod();
			Class<?> clazz = joinPoint.getTarget().getClass();

			Map<String,Object> log=new HashMap<String,Object>(10);
			// 如果存在JAuditModul注解，从注解中获取模块名
			String modul = clazz.getSimpleName();
			if (clazz.isAnnotationPresent(JAuditModul.class)) {
				// 获取权限编码
				JAuditModul jm = clazz.getAnnotation(JAuditModul.class);
				if (!StringUtils.isEmpty(jm.modul())) {
					modul = jm.modul();
				}
			}
			log.put("logModul", modul);
			log.put("logFullName", clazz.getName()+"."+targetMethod.getName());

			String method = targetMethod.getName();
			JAuditLog ja = targetMethod.getAnnotation(JAuditLog.class);
			if (!StringUtils.isEmpty(ja.type())) {
				method = ja.type();
			}
			log.put("logMethod", method);
			
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			log.put("logClient", RequestUtils.getClient(request));
			log.put("logUrl", request.getRequestURI());
			
			
			//AuditLog log = new AuditLog();
			log.put("appCode", JFCloud.getAppCode());
			log.put("logType", "audit");
			log.put("logAccount", "chenbin");
			this.buildAuditLogTime(log, startTime, endTime);
			//主机名和ip
			InetAddress inet=RequestUtils.getInetAddress(request);
			if(inet!=null){
				log.put("logIp", inet.getHostAddress());
				log.put("logHost", inet.getHostName());
			}else{
				log.put("logIp", "Unknown");
				log.put("logHost", "Unknown");
			}
			
			String message=ja.message();
			if(StringUtils.isEmpty(message)){
				log.put("logMessage", JSON.toJSONString(joinPoint.getArgs()));
			}else{
				log.put("logMessage", message);
			}
			service.auditLog(log);
			logger.debug("Audit log end...");
		} catch (Exception e) {
			logger.error("audit log is error:"+e.getMessage());
		}
	}
	
	/**
	 * 构建审计日期
	 * @param log
	 * @param startTime
	 * @param endTime
	 * @autor chenbin
	 * @date 2018-12-09 19:18
	 */
	private void buildAuditLogTime(Map<String, Object> log,Long startTime,Long endTime) {
		//审计日期
		log.put("logTime", new Date(startTime));
		log.put("logStartTime", new Date(startTime));
		log.put("logEndTime", new Date(endTime));
		log.put("logCost", endTime-startTime);
	}

}
