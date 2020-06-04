package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: FindAllServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/14 17:08
 * @Version: V1.0
 **/
@WebServlet("/web/findAll.do")
public class FindAllServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        try {
            List<User> list = userDao.findAll();
            /*resp.setContentType("text/html;charset = utf-8");
            PrintWriter out = resp.getWriter();

            out.println("<h1> 您是管理员</h1><hr>");
            out.println("<html>");
            out.println("<head><title>一下是所有账号信息</title></head>");
            out.println("<body>");
            out.println("<h1>账号列表</h1>");
            for (User user : list) {
                out.println("<ul>");
                out.println("<li>"+user.getId()+"</li>");
                out.println("<li>"+user.getUsername()+"</li>");
                out.println("<li>"+user.getEmail()+"</li>");
                out.println("<li>"+user.getPhone()+"</li>");
                out.println("<li>"+user.getCreated()+"</li>");
                out.println("<li>"+user.getUpdated()+"</li>");
                out.println("</ul>");
                out.println("<hr width='50%' align='left'>");
            }
            out.println("</body>");
            out.println("</html>");

*/

            req.setAttribute("Users",list);

            //转发
            req.getRequestDispatcher("/web/list.jsp").forward(req,resp);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("/web/error.jsp");
        }
    }
}
