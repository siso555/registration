package com.register.core;

import java.io.*;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Inject
    private DatabasePersistence persistence;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String data = request.getParameter("data");
        RequestDispatcher dispatcher;
        try {
            boolean isExist = persistence.getUserByEmailOrUsername(data);
            if (isExist) {
                request.setAttribute("data", data);
                dispatcher = request.getRequestDispatcher("result.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("error.jsp");
            }
        } catch (SQLException e) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        }
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}