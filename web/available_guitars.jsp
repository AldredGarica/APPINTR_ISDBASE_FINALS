<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 18/03/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@
page import="com.dev.model.DatabaseConnModel"
%>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    DatabaseConnModel action = new DatabaseConnModel();

    action.getDBGuitars();
    action.SQLConn();
    response.setContentType("text/html");
    //PrintWriter out = response.getWriter();

    String myvar = "<html lang=\"en\"><head>"+
            "    <title>APPINTR</title>"+
            "    <meta charset=\"UTF-8\">"+
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/iconic/css/material-design-iconic-font.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">"+
            "    <!--===============================================================================================-->"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">"+
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">"+
            "    <!--===============================================================================================-->"+
            "</head>"+
            "<body data-new-gr-c-s-check-loaded=\"8.871.0\" data-gr-ext-installed=\"\">"+
            ""+
            ""+
            "<div class=\"container-login100\" style=\"background-image: url('images/bg-01.jpg');\">"+
            "    <div class=\"wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30\">"+
            "        <form method=\"post\" class=\"login100-form validate-form\" action=\"process.LoginAction\">"+
            "            <span class=\"login100-form-title p-b-37\">AVAILABLE GUITARS</span>"+
            "            "+
            "        </form>"+
            ""+
            "                    "+"<style>\n" +
    "table, th, td {\n" +
    "  border: 1px solid black;\n" +
    "}\n" +
    "</style>"+
    " <table style=\"width:100%\">"+
    "  <tbody><tr>"+
    "    <th>ID</th>"+
    "    <th>Guitar Name</th>"+
    "    <th>Guitar Price</th>"+
    "  </tr>"+
    action.getgDBAppendedData() +
            ""+
            "    </div>"+
            "</div>"+
            ""+
            ""+
            ""+
            "<div id=\"dropDownSelect1\"></div>"+
            ""+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/animsition/js/animsition.min.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/bootstrap/js/popper.js\"></script>"+
            "<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/select2/select2.min.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/daterangepicker/moment.min.js\"></script>"+
            "<script src=\"vendor/daterangepicker/daterangepicker.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"vendor/countdowntime/countdowntime.js\"></script>"+
            "<!--===============================================================================================-->"+
            "<script src=\"js/main.js\"></script>"+
            ""+
            ""+
            "</body></html>";

    out.println(myvar);

    //out.println(action.getgDBAppendedData());
%>
</body>
</html>
