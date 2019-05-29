package com.ithuang.tomcat;

import java.io.IOException;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@WebServlet(urlPattern = "/test02")
public class Test02Servlet extends HttpServlet{
    @Override
    public void doPost(HttpRequestServlet req, HttpResponceServlet resp) {

    }

    @Override
    public void doGet(HttpRequestServlet req, HttpResponceServlet resp)  {
        System.out.println("请求02");
        try {
            resp.write("响应02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
