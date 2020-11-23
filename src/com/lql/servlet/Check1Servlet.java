package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: Check1Servlet <br>
 * ProjectName: javaWeb <br>
 * description: 重定向测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 15:06 <br>
 */
public class Check1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String message = null;

        if (username == null) {
            message = "Please input username.";
        }else {
            message = "Hello," + username;
        }

        req.setAttribute("msg", message);

        out.println("Output from CheckServlet before redirecting.");
        System.out.println("Output from CheckServlet before redirecting.");

        resp.sendRedirect("/javaWeb/output1?msg=" + message);

        out.println("Output from CheckServlet after redirecting.");
        System.out.println("Output from CheckServlet after redirecting.");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
