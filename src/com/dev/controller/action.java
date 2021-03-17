package com.dev.controller;

import com.dev.model.LoginModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;


public class action extends HttpServlet {
    private String usernamex;
    private String passwordx;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usernamex = request.getParameter("username");
        passwordx = request.getParameter("password");
        LoginModel action = new LoginModel();

        action.setUsernamex(usernamex);
        action.setPasswordx(passwordx);
        try {
            action.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(action.isLoginAccepted() == true) {
            request.setAttribute("d24mcx432", action);
            RequestDispatcher dispatcher = request.getRequestDispatcher("display.html");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("error.html");
        }
    }

    public void destroy() {
        System.out.println("servlet taken out of service.");
    }

}
