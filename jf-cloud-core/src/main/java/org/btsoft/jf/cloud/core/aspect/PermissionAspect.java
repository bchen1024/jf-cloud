package org.btsoft.jf.cloud.core.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.btsoft.jf.cloud.core.annotation.JOperator;
import org.btsoft.jf.cloud.core.annotation.JResource;
import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.context.JFCloud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 权限校验拦截器
 * @author chenbin
 * @date 2018年6月9日 下午11:59:48
 */
@Component
@Aspect
@Order(-100)
public class PermissionAspect {
	
	private final static Logger logger=LoggerFactory.getLogger(PermissionAspect.class);
	
	@Pointcut("@annotation(org.btsoft.jf.cloud.core.annotation.JOperator)")  
    public void jOperator() {}

    @Before("jOperator()")
    public void doBefore(JoinPoint joinPoint) {
    	logger.debug("Permission check start...");
    	//获取拦截的方法
    	Signature signature=joinPoint.getSignature();
    	MethodSignature methodSignature = (MethodSignature)signature;    
        Method targetMethod = methodSignature.getMethod();
    	Class<?> clazz=joinPoint.getTarget().getClass();
    	
    	//检查类上是否存在JResource注解
    	if(!clazz.isAnnotationPresent(JResource.class)){
    		logger.warn("@JResource annotation on class missing");
    		return;
    	}
    	
    	//获取权限编码
    	JResource jr=clazz.getAnnotation(JResource.class);
    	JOperator jo=targetMethod.getAnnotation(JOperator.class);
    	StringBuffer sb=new StringBuffer();
    	sb.append(JFCloud.getAppCode()).append("$").append(jr.code()).append("$").append(jo.code());
    	
    	RequestContext rc=RequestContext.getCurrent(true);
    	logger.info(String.format("Permission code is [%s]", sb));
    }

}