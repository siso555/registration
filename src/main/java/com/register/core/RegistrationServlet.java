package com.register.core;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Inject
    private DatabasePersistence persistence;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeatedPassword");
        String profession = request.getParameter("profession");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        if (Objects.equals(password, repeatedPassword)) {
            UserEntity user = new UserEntity();
            user.setFirstname(firstname);
            user.setPassword(password);
            user.setProfession(profession);
            user.setLastname(lastname);
            user.setFirstname(firstname);
            user.setUsername(username);
            RequestDispatcher dispatcher;
            try {
                int res = persistence.registerUser(user);
                if (res == 1) {
                    request.setAttribute("data", email);
                    dispatcher = request.getRequestDispatcher("register.jsp");
                    dispatcher.forward(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("error.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }
}