package com.dev.controller;

import com.dev.model.DatabaseConnModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class PerformRemoveGuitarAction extends HttpServlet {
    private String rGuitar;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        rGuitar = req.getParameter("rGuitar");

        if (rGuitar != null) {
            DatabaseConnModel action = new DatabaseConnModel();

            action.setrGuitar(rGuitar);
            action.RemoveGuitar();
            try {
                action.SQLConn();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resp.sendRedirect("remove-guitar.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}
