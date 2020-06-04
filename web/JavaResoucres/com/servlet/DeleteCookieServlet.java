package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: DeleteCookieServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/28 10:13
 * @Version: V1.0
 **/
@WebServlet("/web/deleteCookie.do")
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("删除成功");
        Cookie[] cookies = req.getCookies();
        if (cookies!=null)
            for (Cookie cookie : cookies) {
                if ("cf".equals(cookie.getName())){
                    //删除cookie，把cookie有效期置为0
                    cookie.setMaxAge(0);
                    //覆盖一下原来的cookie
                    resp.addCookie(cookie);
                    //重定向
                    resp.sendRedirect("/web/success.jsp");
                }
            }
    }
}
