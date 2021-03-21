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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rGuitar = req.getParameter("rGuitar");

        if (rGuitar != null) {
            DatabaseConnModel action = new DatabaseConnModel();

            action.setrGuitar(rGuitar);
            action.SQLQuery(3);
            try {
                action.SQLConn();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("d24mcx432", action);
            RequestDispatcher dispatcher = req.getRequestDispatcher("remove-guitar.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}
