package org.btsoft.jf.cloud.core.context;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Spring 上下文管理器
 * @author chenbin
 * @date 2018年6月13日 下午9:42:17
 */
public final class JFCloud {

	private static ApplicationContext context;
	
	public static void setApplicationContext(ApplicationContext applicationContext){
		if(context==null){
			context=applicationContext;
		}
	}
	
	public static ApplicationContext getContent(){
		return context;
	}
	
	public static String getAppCode(){
		return context.getEnvironment().getProperty("jf.cloud.appCode");
	}
	
	public static String getCurrentAppCode() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String appCode=request.getHeader("x-app-code");
		return appCode;
	}
	
	public static String getEnv() {
		return context.getEnvironment().getProperty("spring.profiles.active");
	}
}
