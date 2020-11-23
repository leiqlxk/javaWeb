package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: CookieServlet <br>
 * ProjectName: javaWeb <br>
 * description: cookie操作 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 11:15 <br>
 */
public class CookieServlet extends HttpServlet {

    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        //获得HTTP请求中所有的cookie
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                writer.println("Cookie name:" + cookies[i].getName());
                writer.println("Cookie value:" + cookies[i].getValue());
                writer.println("Max age:" + cookies[i].getMaxAge() + "\r\n");
            }
        }else {
            writer.println("No cookie.");
        }

        resp.addCookie(new Cookie("cookieName" + count, "cookieValue" + count));
        count++;
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
