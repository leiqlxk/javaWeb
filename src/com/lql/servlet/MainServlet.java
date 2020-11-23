package com.lql.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: MainServlet <br>
 * ProjectName: javaWeb <br>
 * description: 包含测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 14:18 <br>
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        //输出html文档
        out.println("<html><head><title>MainServlet</title></head>");
        out.println("<body>");

        RequestDispatcher headerDispatcher = req.getRequestDispatcher("/header.html");
        RequestDispatcher greetDispatcher = req.getRequestDispatcher("/greet");
        RequestDispatcher footerDispatcher = req.getRequestDispatcher("/footer.html");

        headerDispatcher.include(req, resp);
        greetDispatcher.include(req, resp);
        footerDispatcher.include(req, resp);

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
