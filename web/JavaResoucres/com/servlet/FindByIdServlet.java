package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName: FindByIdServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/17 08:57
 * @Version: V1.0
 **/
@WebServlet("/web/findById.do")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");

        Integer id = Integer.parseInt(strId);

        System.out.println(id);
        UserDao userDao = new UserDao();

        try {
            User user = userDao.findById(id);


            req.setAttribute("user",user);
            req.getRequestDispatcher("/web/update.jsp").forward(req,resp);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("/web/error.jsp");
        }

    }
}
