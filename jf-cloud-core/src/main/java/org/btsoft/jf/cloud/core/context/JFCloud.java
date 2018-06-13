package org.btsoft.jf.cloud.core.context;

import org.springframework.context.ApplicationContext;

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
}
