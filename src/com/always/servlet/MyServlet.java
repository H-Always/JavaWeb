package com.always.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName: MyServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/03/13 12:31
 * @Version: V1.0
 **/

@WebServlet("/test")
public class MyServlet implements Servlet {
    private String username;

    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获得当前的servlet名字，就是xml里面配置的名字
        System.out.println(servletConfig.getServletName());

        //把当前xml的配置信息获取到，给出键，获取到相应的值
        this.username = servletConfig.getInitParameter("username");
        System.out.println(this.username);

        //这是一个和迭代器，可以把它理解为set集合，他存放所有initParameter的值，一般用来遍历初始化参数
        Enumeration<String> enumeration =  servletConfig.getInitParameterNames();
        //遍历集合调用一下hasMoreElements方法，判断时候存在下一个，就和if(node,next)一样
        while (enumeration.hasMoreElements()){
            String str = enumeration.nextElement();
            System.out.println(str);
        }

        //返回servletContext对象，他是servlet的上下文，整个servlet的管理者
        //servletConfig的作用范围仅仅是当前servlet的某一个实例，而servletContext则是可以获取到全局的信息
        ServletContext servletContext = servletConfig.getServletContext();
        //获得当前的路径，就是tomcat里的配置路径
        System.out.println("当前配置的路径为"+servletContext.getContextPath());
        //获取当前服务器的信息，就是版本信息
        System.out.println("当前tomcat版本为:"+servletContext.getServerInfo());


    }

    //获取servlet的一些相关信息，名字呀，初始化参数啊
    @Override
    public ServletConfig getServletConfig() {
        System.out.println(getServletConfig().getServletName()) ;
        return null;
    }

    //处理客户端请求，核心，业务逻辑处理
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String s = servletRequest.getParameter("id");
        servletResponse.setContentType("text/html;charset=utf-8");
    }

    //返回一个子串
    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁，这个是有生命周期的，释放资源
    @Override
    public void destroy() {
        System.out.println("释放资源成功");

    }
}
