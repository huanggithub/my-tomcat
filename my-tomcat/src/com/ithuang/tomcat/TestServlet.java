package com.ithuang.tomcat;

import java.io.IOException;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@WebServlet(urlPattern = "/test")
public class TestServlet extends HttpServlet{
    @Override
    public void doGet(HttpRequestServlet req, HttpResponceServlet resp) {
        System.out.println("请求01");
        try {
            resp.write("响应01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpRequestServlet req, HttpResponceServlet resp) {

    }
}
