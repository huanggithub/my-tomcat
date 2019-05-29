package com.ithuang.tomcat;


/**
 * create by Mr.huang
 * 666
 * 666
 */

public class HttpServlet implements Servlet {
    @Override
    public void service(HttpRequestServlet req, HttpResponceServlet resp) throws Exception{
        /**
         * 分析请求头
         * 获得请求方式 get | post
         * 请求转发到对应的方法中
         */
        if("GET".equals(req.getMethod())){
            doGet(req,resp);
        }else{
            doPost(req,resp);
        }
    }
    public void doGet(HttpRequestServlet req, HttpResponceServlet resp){

    }
    public void doPost(HttpRequestServlet req, HttpResponceServlet resp){

    }
}
