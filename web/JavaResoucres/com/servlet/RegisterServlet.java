package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @ClassName: RegisterServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/09 16:20
 * @Version: V1.0
 **/

@WebServlet("/web/regist.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("userPwd");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        User user = new User(userName,password,email,phone);
        UserDao userDao = new UserDao();

        try {

            if (userDao.findByUser(userName)){
                req.setAttribute("registerError","用户名已存在，请重新输入");
                req.getRequestDispatcher("/web/register.jsp").forward(req,resp);
            } else{
                userDao.save(user);
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println(userName+"<h1> 您已注册成功1111</h1><hr>");
                out.println("<a href = '/web/login.jsp'>登录</a>");
                out.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("/web/error.jsp");
        }


    }
}
