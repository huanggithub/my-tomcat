# 利用自定义注解、反射等实现简单的Tomcat
```java
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
```
