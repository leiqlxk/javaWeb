package com.lql.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: CheckServlet <br>
 * ProjectName: javaWeb <br>
 * description: 请求转发测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 13:34 <br>
 */
public class CheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String message = null;

        if (username == null) {
            message = "Please input username";
        }else {
            message = "Hello," + username;
        }

        //在request中添加msg属性
        req.setAttribute("msg", message);

        //把请求转发给outputServlet
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("output");
        /*RequestDispatcher requestDispatcher = req.getRequestDispatcher("/output");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("output");*/

        PrintWriter out = resp.getWriter();
        out.println("Output from CheckServlet before forwarding request.");
        System.out.println("Output from CheckServlet before forwaiding request.");

        requestDispatcher.forward(req, resp);

        out.println("Output from CheckServlet after forwarding request.");
        System.out.println("Output from CheckServlet after forwaiding request.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
