package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName: DeleteServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/16 17:05
 * @Version: V1.0
 **/
@WebServlet("/web/delete.do")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        int id  = Integer.parseInt(strId);

        UserDao userDao = new UserDao();

        try {
            userDao.delete(id);
            //重定向

            resp.sendRedirect("findAll.do");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
