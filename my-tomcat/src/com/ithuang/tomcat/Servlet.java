package com.ithuang.tomcat;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * create by Mr.huang
 * 666
 * 666
 */
public interface Servlet {
    void service(HttpRequestServlet req,HttpResponceServlet resp) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception;
}
