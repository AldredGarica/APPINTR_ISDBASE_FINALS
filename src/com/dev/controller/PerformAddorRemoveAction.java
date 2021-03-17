package com.dev.controller;

import com.dev.model.DatabaseConnModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class PerformAddorRemoveAction extends HttpServlet {
    private String gName;
    private float gPrice;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gName = req.getParameter("gName");
        gPrice = Float.parseFloat(req.getParameter("gPrice"));
        DatabaseConnModel action = new DatabaseConnModel();

        action.setgNamex(gName);
        action.setgPricex(gPrice);
        action.AddGuitar();
        try {
            action.SQLConn();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("success-guitar.jsp");
        System.out.println("HELLO WORLD");
    }
}
