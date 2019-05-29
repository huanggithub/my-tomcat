package com.ithuang.tomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * create by Mr.huang
 * 666
 * 666
 */

public class HttpResponceServlet {
    private OutputStream outputStream;

    public HttpResponceServlet(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String s) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;charset=utf-8\n")
                .append("\n");

        sb.append(s);
        outputStream.write(sb.toString().getBytes());
    }
}
