package com.dev.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dev.model.DatabaseConnModel;
import com.dev.bean.RegisterBean;
import com.dev.data.RegisterData;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterAction extends HttpServlet {
 
     public RegisterAction() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String email = request.getParameter("email");
         String userName = request.getParameter("username");
         String password = request.getParameter("password");
         
         RegisterBean registerBean = new RegisterBean();
         registerBean.setEmail(email);
         registerBean.setUserName(userName);
         registerBean.setPassword(password); 
         
         RegisterData registerData = new RegisterData();
         
         String userRegistered = registerData.registerUser(registerBean);
         
         if(userRegistered.equals("SUCCESS"))
         {
            request.getRequestDispatcher("/display.html").forward(request, response);
         }
         else
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
     }