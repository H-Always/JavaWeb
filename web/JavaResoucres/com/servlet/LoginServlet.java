package com.servlet;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LoginServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/09 08:25
 * @Version: V1.0
 **/


@WebServlet("/web/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)  {
         String username = req.getParameter("username");
         String password = req.getParameter("password");

         //自动登录
         String isAuto = req.getParameter("isAuto");

        System.out.println(username);
        System.out.println(password);


         UserDao userDao= new UserDao();

        System.out.println("初始化完毕");

        try {
            User user = userDao.findByUser(username,password);


            if (user!=null){

                //记住账号密码
                if (isAuto!=null){
                    Cookie cookieUsername = new Cookie("username",username);
                    Cookie cookiePassword = new Cookie("password",password);
                    cookieUsername.setMaxAge(7*24*60*60);
                    cookiePassword.setMaxAge(7*24*60*60);
                    cookieUsername.setPath("/");
                    cookiePassword.setPath("/");
                    resp.addCookie(cookieUsername);
                    resp.addCookie(cookiePassword);
                }

                int type = user.getType();

                if (type==1)
                    resp.sendRedirect("/web/admin.jsp");
                else
                    resp.sendRedirect("/web/main.jsp");
            } else{
                req.setAttribute("upError","账号或密码错误");
                // 转发
                req.getRequestDispatcher("login.jsp").forward(req,resp);

                // 重定向
                //resp.sendRedirect("/web/login.jsp");
            }


        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }


    }
}
