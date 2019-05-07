package org.btsoft.jf.cloud.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName JResource
 * @Description 类上权限控制注解
 * @author bchen
 * @created 2018-4-5 18:51:16
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface JResource {

	public String code();// 资源编码

	public String descCN();// 资源中文描述

	public String descEN();// 资源英文描述
	
	public String appCode() default "";
}
