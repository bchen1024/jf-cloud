package org.btsoft.jf.cloud.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName JAuditLog
 * @Description 方法上审计日志注解
 * @author bchen
 * @created 2018-4-5 18:51:16
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JAuditLog {

	public String type() default "";// 操作类型

	public String message() default "";// 操作描述

}
