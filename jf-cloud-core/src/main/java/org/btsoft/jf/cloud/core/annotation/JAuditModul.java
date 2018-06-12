package org.btsoft.jf.cloud.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName JAuditModul
 * @Description 类上审计模块
 * @author bchen
 * @created 2018-4-5 18:51:16
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface JAuditModul {

	public String modul() default "";// 审计模块
}
