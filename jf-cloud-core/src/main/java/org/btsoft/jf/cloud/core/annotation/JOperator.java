package org.btsoft.jf.cloud.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.btsoft.jf.cloud.core.enums.SecurityEnums;

/**
 * @ClassName JOperator
 * @Description 方法上权限控制注解
 * @author bchen
 * @created 2018-4-5 18:51:16
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JOperator {

	public String code() default "";// 权限code

	public String descCN();// 权限中文描述

	public String descEN();// 权限英文描述

	public SecurityEnums security() default SecurityEnums.LoginUser;
}
