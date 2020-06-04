package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: SaveCookieServlet
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/28 10:07
 * @Version: V1.0
 **/
@WebServlet("/web/saveCookie.do")
public class SaveCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("保存成功");

    }
}
