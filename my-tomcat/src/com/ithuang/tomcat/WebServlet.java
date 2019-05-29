package com.ithuang.tomcat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create by Mr.huang
 * 666
 * 666
 * 自定义WebServlet注解
 */
//作用在类上
@Target(ElementType.TYPE)
//一直存在
@Retention(RetentionPolicy.RUNTIME)
public @interface WebServlet {
    String urlPattern();
}
