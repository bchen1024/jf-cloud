package org.btsoft.jf.cloud.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author chenbin
 * @date 2018年6月13日 下午9:45:29
 */
@Component
public class JFCloudApplicationContextAware implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		JFCloud.setApplicationContext(applicationContext);
	}

}
