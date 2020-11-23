package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: GreetServlet <br>
 * ProjectName: javaWeb <br>
 * description: 包含测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 14:27 <br>
 */
public class GreetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hi," + req.getParameter("username") + "<p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
