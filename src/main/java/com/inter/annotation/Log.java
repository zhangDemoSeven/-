package com.inter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface Log {

	 public String operationType() default "";  //方法类型
	 public String operationName() default "";   //方法名称 
	 public String operationSource() default ""; //数据源
}