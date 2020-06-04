package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName: UpdateServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/17 09:21
 * @Version: V1.0
 **/
@WebServlet("/web/update.do")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");

        Integer id = Integer.parseInt(strId);

        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        UserDao userDao = new UserDao();
        User user = new User();

        user.setId(id);
        user.setEmail(email);
        user.setPhone(phone);


        try {
            userDao.update(user);
            resp.sendRedirect("findAll.do");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
