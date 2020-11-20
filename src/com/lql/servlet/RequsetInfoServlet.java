package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: RequsetInfoServlet <br>
 * ProjectName: javaWeb <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/18 17:34 <br>
 */
public class RequsetInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><head><tittle>RequestInfo</tittle></head>");
        printWriter.println("<body>");
        printWriter.println("<br>LocalAddr:" + req.getLocalAddr());
        printWriter.println("<br>LocalName:" + req.getLocalName());
        printWriter.println("<br>LocalPost:" + req.getLocalPort());
        printWriter.println("<br>Protocol:" + req.getProtocol());
        printWriter.println("<br>RemoteAddr:" + req.getRemoteAddr());
        printWriter.println("<br>RemoteName:" + req.getRemoteUser());
        printWriter.println("<br>RemoteHost:" + req.getRemoteHost());
        printWriter.println("<br>RemotePort:" + req.getRemotePort());
        printWriter.println("<br>Method:" + req.getMethod());
        printWriter.println("<br>URI:" + req.getRequestURI());
        printWriter.println("<br>URL:" + req.getRequestURL());
        printWriter.println("<br>ContextPath:" + req.getContextPath());
        printWriter.println("<br>QueryString:" + req.getQueryString());
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
