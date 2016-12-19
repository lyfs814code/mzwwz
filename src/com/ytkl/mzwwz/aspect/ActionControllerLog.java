package com.ytkl.mzwwz.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionControllerLog {

	/** 渠道 */
	String channel() default "web";

	/** 标题 */
	String title() default "";

	/** 动作的名称 */
	String action() default "";

	/** 是否保存请求的参数 */
	boolean isSaveRequestData() default false;
}
