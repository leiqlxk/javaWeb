package com.lql.servlet;


import javax.servlet.*;
import java.io.IOException;

/**
 * Title: com.lql.servlet.DispatcherServlet <br>
 * ProjectName: javaWeb <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/10 13:50 <br>
 */
public class DispatcherServlet extends GenericServlet {

    String target = "/hello.jsp";

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");

        String password = servletRequest.getParameter("password");

        servletRequest.setAttribute("USER", username);
        servletRequest.setAttribute("PASSWORD", password);

        ServletContext servletContext = getServletContext();

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(target);
        dispatcher.forward(servletRequest, servletResponse);
    }
}
