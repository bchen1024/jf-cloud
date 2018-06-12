package org.btsoft.jf.cloud.core.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.btsoft.jf.cloud.core.annotation.JAuditLog;
import org.btsoft.jf.cloud.core.annotation.JAuditModul;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 审计日志拦截器
 * @author chenbin
 * @date 2018年6月11日 下午9:19:52
 */
@Component
@Aspect
@Order(Integer.MAX_VALUE)
public class AuditLogAspect {
	
private final static Logger logger=LoggerFactory.getLogger(AuditLogAspect.class);
	
	@Pointcut("@annotation(org.btsoft.jf.cloud.core.annotation.JAuditLog)")  
    public void jAuditLog() {}

    @After("jAuditLog()")
    public void doBefore(JoinPoint joinPoint) {
    	logger.debug("Audit log start...");
    	//获取拦截的方法
    	Signature signature=joinPoint.getSignature();
    	MethodSignature methodSignature = (MethodSignature)signature;    
        Method targetMethod = methodSignature.getMethod();
    	Class<?> clazz=joinPoint.getTarget().getClass();
    	
    	String modul=clazz.getSimpleName();
    	//如果存在JAuditModul注解，从注解中获取模块名
    	if(clazz.isAnnotationPresent(JAuditModul.class)){
    		//获取权限编码
    		JAuditModul jm=clazz.getAnnotation(JAuditModul.class);
    		if(!StringUtils.isEmpty(jm.modul())){
    			modul=jm.modul();
    		}
    	}
    	
    	String type=targetMethod.getName();
    	JAuditLog ja=targetMethod.getAnnotation(JAuditLog.class);
    	if(!StringUtils.isEmpty(ja.type())){
    		type=ja.type();
    	}
    	
    	logger.info(String.format("AuditLog is [%s.%s]", modul,type));
    }

}
