package com.dev.controller;

import com.dev.model.DatabaseConnModel;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


public class PerformAddGuitarAction extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String gName = req.getParameter("gName");
        String gPrice = req.getParameter("gPrice");

        if (gPrice != null && gName != null) {
            DatabaseConnModel action = new DatabaseConnModel();

            action.setgNamex(gName);
            action.setgPrice(gPrice);
            //action.AddGuitar();
            action.SQLQuery(1);
            try {
                action.SQLConn();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resp.sendRedirect("success-guitar.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}

