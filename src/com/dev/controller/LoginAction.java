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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DatabaseConnModel action = new DatabaseConnModel();

        action.setUsernamex(username);
        action.setPasswordx(password);
        try {
            action.SQLQuery(4);
            action.SQLConn();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(action.isLoginAccepted()) {
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
