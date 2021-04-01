package com.dev.controller;

import com.dev.model.DatabaseConnModel;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


public class PerformAddGPUAction extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String gName = req.getParameter("gName");
        String gPrice = req.getParameter("gPrice");

        if (gPrice != null && gName != null) {
            DatabaseConnModel action = new DatabaseConnModel();

            action.setGPUName(gName);
            action.setGPUPrice(gPrice);
            try {
                action.SQLConn(1,true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resp.sendRedirect("success-gpu.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}

