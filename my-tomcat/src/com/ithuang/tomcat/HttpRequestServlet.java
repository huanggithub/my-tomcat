package com.ithuang.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Mr.huang
 * 666
 * 666
 * 暂时没有对请求参数做处理
 */
public class HttpRequestServlet {
    private String method;
    private String url;
    private String servletName;
    private Map parameter = new HashMap();

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getServletName() {
        return servletName;
    }

    public String getParameter(String s) {
        return "1";
    }

    public void setParameter(Map parameter) {
        this.parameter = parameter;
    }

    public HttpRequestServlet(InputStream inputStream) throws IOException {
        String s = new BufferedReader(new InputStreamReader(inputStream)).readLine();
        System.out.println(s);
        String[] s1 = s.split(" ");
        this.method = s1[0];
        System.out.println(this.method);
        this.url = s1[1];
        this.servletName = s1[1];
        System.out.println(this.servletName);
    }

}
