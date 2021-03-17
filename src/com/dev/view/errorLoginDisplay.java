package com.dev.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/error.html")
public class errorLoginDisplay extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set the MIME type response
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<head>");
        out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/iconic/css/material-design-iconic-font.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">");
        out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">");
        out.print("</head>");
        out.print("<body>");

        out.print("<div class=\"container-login100\" style=\"background-image: url('images/bg-01.jpg');\">");
        out.print("<div class=\"wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30\">");
        out.print("<form class=\"login100-form validate-form\" action=\"index.html\">");
        out.print("<span class=\"login100-form-title p-b-37\">Error Page</span>");
        out.print("<center><font size=\"+1.8\"><p>Incorrect Login Combination</font></p></center>");
        out.print("<div class=\"container-login100-form-btn\">");
        out.print("<button class=\"login100-form-btn\">");
        out.print("Return");
        out.print("</button>");
        out.print("</div>");
        out.print("</body>");
        out.print("</html>");

    }
}
