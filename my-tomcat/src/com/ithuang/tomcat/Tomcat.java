package com.ithuang.tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Mr.Huang
 * 666
 * 666
 * CREATE-TIME 2019年5月29日 17:41:55
 *
 * 基于HTTP1.1
 * 需求分析：根据Tomcat&Servlet执行原理 做一个简单版本的Tomcat服务器&Servlet类
 *
 *  - 1.定义Tomcat入口类，监听请求
 *  - 2.自定义WebServlet注解，实现urlPattern属性
 *  - 3.定义HttpRequestServlet，请求输入流
 *  - 4.定义HttpResponceServlet，响应输入流
 *  - 5.定义Servlet接口，提供service静态方法
 *  - 6.定义HttpServlet，实现Servlet接口，通过url判断实现请求转发  get|post
 *  - 7.定义TestServlet&Test02Servlet测试类
 */
public class Tomcat {

    private List<String> list = new ArrayList<>();//存储类的全限定名
    private Map<String,Servlet> servletMap = new HashMap();//存储Servlet类

    /**
     * Tomcat入口
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 链式编程
        new Tomcat().init().listen();
    }

    /**
     * 监听一次性请求
     * 如果要进行多次连接  while 循环即可
     * @throws IOException
     */
    public void listen() throws Exception {
        //ServerSocket监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //连接
        Socket accept = serverSocket.accept();
        //获取输入输出流
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        //将输入输出流传入HttpRequestServlet&&HttpResponceServlet 对象
        HttpRequestServlet httpRequestServlet = new HttpRequestServlet(inputStream);
        HttpResponceServlet httpResponceServlet = new HttpResponceServlet(outputStream);
        //获取请求Url
        String url = httpRequestServlet.getUrl();
        //从容器中取出对应的Servlet
        Servlet servlet = servletMap.get(url);
        //调用service方法
        servlet.service(httpRequestServlet,httpResponceServlet);
        //释放资源
        inputStream.close();
        accept.close();
        serverSocket.close();
    }


    /**
     * 初始化
     * @return 返回Tomcat本身实现链式编程
     * @throws Exception
     */
    public Tomcat init() throws Exception {
        //获取src的路径
        String resource = Tomcat.class.getResource("/").getPath();
        //处理文件
        file(resource,list);
        //遍历获取Servlet并存入容器
        for (String s:list) {
            Class<?> servletClass = Class.forName(s);
            WebServlet webServlet = servletClass.getAnnotation(WebServlet.class);
            servletMap.put(webServlet.urlPattern(), (Servlet) servletClass.newInstance());
        }
        return this;
    }
    public void file(String url,List<String> list) throws Exception {
        //得到文件流的数组
        File[] files = new File(url).listFiles();
        //递归遍历
        for (File f: files) {
            if(f.isDirectory()){
                //如果是文件夹递归继续遍历
                file(f.getPath(),list);
            }else{
                //对路径进行处理
                String replace = f.getAbsolutePath().replace("C:\\Black\\Demo\\workSpace\\out\\production\\my-tomcat\\", "");
                String replace1 = replace.replace(".class", "");
                String replace2 = replace1.replace("\\", ".");
                //判断是否为Servlet
                if(isServlet(replace2)){
                    //存入容器
                    list.add(replace2);
                }
            }
        }
    }

    /**
     * 判断是否为有WebServlet注解的Servlet
     * @param s
     * @return
     * @throws Exception
     */
    public boolean isServlet(String s) throws Exception {
        //反射获取对应类
        Class<?> aClass = Class.forName(s);
        //判断aClass是否为assignableFrom的子类
        boolean assignableFrom = Servlet.class.isAssignableFrom(aClass);
        if(assignableFrom){
            //判断是有WebServlet注解
            WebServlet webServlet = aClass.getAnnotation(WebServlet.class);
            if (webServlet != null) {
                return true;
            }
        }
        return false;
    }

}
