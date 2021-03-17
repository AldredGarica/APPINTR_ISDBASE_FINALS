package com.dev.controller;

import com.dev.model.DatabaseConnModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;


public class LoginAction extends HttpServlet {
    private String username;
    private String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        password = request.getParameter("password");
        DatabaseConnModel action = new DatabaseConnModel();

        action.setUsernamex(username);
        action.setPasswordx(password);
        try {
            action.CheckLogin();
            action.SQLConn();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(action.isLoginAccepted() == true) {
            request.setAttribute("d24mcx432", action);
            RequestDispatcher dispatcher = request.getRequestDispatcher("display.html");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("error.jsp");
        }
    }

    public void destroy() {
        System.out.println("servlet taken out of service.");
    }

}
