package com.dev.model;

import java.sql.*;
import java.util.Properties;
public class DatabaseConnModel {

    private final Object userName = "newuser";
    private final Object password = "password";
    private final Object serverName = "1.tcp.ap.ngrok.io";
    private final int portNumber = Integer.parseInt("21243");
    private String SQLString = "";

    //Username, Password and Boolean
    private String usernamex;
    private String passwordx;
    private boolean loginAccepted = false;
    //Add Guitar
    private String gName;
    private String gPrice;
    private String gPicture;
    //Remove Guitar
    private String rGuitar;
    //Show Additional Error
    private String rGuitarInfo = "";
    //Get All Guitars
    private String gDBAppendedData = "";


    //Mutator Method
    public void setgDBAppendedData(String gDBAppendedData) {
        this.gDBAppendedData = gDBAppendedData;
    }
    public String getgDBAppendedData(){
        return gDBAppendedData;
    }
    public String getrGuitarInfo() {
        return rGuitarInfo;
    }
    public String getSQLString() {
        return SQLString;
    }
    public void setrGuitarInfo(String rGuitarInfo) {
        this.rGuitarInfo = rGuitarInfo;
    }
    public void setgNamex(String gNamex) {
        this.gName = gNamex;
    }
    public void setgPrice(String gPrice) {
        this.gPrice = gPrice;
    }
    public void setgPicture(String gPicture) { this.gPicture = gPicture; }
    public void setrGuitar(String rGuitar) {
        this.rGuitar = rGuitar;
    }
    public void setPasswordx(String passwordx) {
        this.passwordx = passwordx;
    }
    public void setUsernamex(String usernamex) {
        this.usernamex = usernamex;
    }
    public void setSQLString(String SQLString) {
        this.SQLString = SQLString;
    }
    public void setLoginAccepted(boolean loginAccepted) {
        this.loginAccepted = loginAccepted;
    }
    public boolean isLoginAccepted() {
        return loginAccepted;
    }

    // TEST PUSH FROM HENRY LADESMA
    public DatabaseConnModel(){
    }

    public void SQLConn(int Query, boolean SQLConn) throws SQLException {

        switch (Query) {
            case 1:
                setSQLString("INSERT INTO finals.guitars (gName, gPrice, gPicture) VALUES (?, ?, ?)");
                break;
            case 2:
                setSQLString("SELECT * FROM finals.guitars");
                break;
            case 3:
                setSQLString("DELETE from finals.guitars WHERE gName = ?");
                break;
            case 4:
                setSQLString("SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?");
                break;
            default:
                break;
        }

        /**
         * NOTES BY: FRANCIS MICO A. ROOSARIO ID#11846551
         *
         * This part will try to connect to MySQL Database; 0.tcp.ap.ngrok is a reverse ssh connection, linking directly to my RasberryPi4 Database located at my home.
         * **/
        if(SQLConn) {
            Connection conn;
            Properties connectionProps = new Properties();
            connectionProps.put("user", this.userName);
            connectionProps.put("password", this.password);

            conn = DriverManager.getConnection(
                    "jdbc:mysql://" +
                            serverName +
                            ":" + portNumber + "/",
                    connectionProps);
            String SQLQuery = getSQLString();
            PreparedStatement stmt = conn.prepareStatement(SQLQuery);

            /**
             * This part will use a switch statement to check and perform the selected SQL Query;
             */
            switch (getSQLString()) {
                case "SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?": {
                    stmt.setString(1, usernamex);
                    stmt.setString(2, passwordx);
                    ResultSet result = stmt.executeQuery();
                    if (result.next()) {
                        System.out.println("Login Details: ");
                        System.out.println("Username(ColumnIndex#2): " + result.getString(2));
                        System.out.println("Password(ColumnIndex#3): " + result.getString(3));
                        setLoginAccepted(true);
                    } else {
                        System.out.println();
                        System.out.println("Incorrect Username / Password");
                    }
                    break;
                }
                case "INSERT INTO finals.guitars (gName, gPrice, gPicture) VALUES (?, ?, ?)": {
                    stmt.setString(1, gName);
                    stmt.setString(2, gPrice);
                    stmt.setString(3, gPicture);
                    int result = stmt.executeUpdate();
                    System.out.println();
                    if (result > 0) {
                        System.out.println("Add Guitar Success!");
                    } else {
                        System.out.println("Add Guitar Failed!");
                    }
                    break;
                }
                case "DELETE from finals.guitars WHERE gName = ?": {
                    stmt.setString(1, rGuitar);
                    int result = stmt.executeUpdate();
                    System.out.println();
                    if (result > 0) {
                        System.out.println("Guitar " + rGuitar + " have been deleted.");
                        setrGuitarInfo("<b><p>Guitar " + rGuitar + " Have been deleted, Click the Return Button.</b></p>");
                    } else {
                        setrGuitarInfo("<b><p>Guitar " + rGuitar + " Have not been removed / Unidentified Problem Occurred, Click the Return Button.</b></p>");
                        System.out.println("Error Occurred");
                    }
                    break;
                }
                case "SELECT * FROM finals.guitars": {
                    ResultSet result = stmt.executeQuery();
                    StringBuilder builder = new StringBuilder();
                    while (result.next()) {
                        String gPM = result.getString("id");
                        String gName = result.getString("gName");
                        String gPrice = result.getString("gPrice");
                        String gPicture = result.getString("gPicture");
                        System.out.println();
                        builder.append("<tr><td>").append(gPM).append("</td><td>").append(gName).append("</td><td>").append(gPrice).append(" PHP").append("</td><td><a href=\"").append(gPicture).append("\"><img src=\"").append(gPicture).append("\" alt=\"i.imgur.com\" style=\"width:48px;height:48px;\"></a>").append("</td></tr>");
                        String AppendedDBGuitars = builder.toString();
                        setgDBAppendedData(AppendedDBGuitars);
                    }
                    break;
                } /** This is the part where you can add another case statement, make sure to delete this comment **/
            }
        }else{
            System.out.println("SQL Connection is set to False");
        }
    }

}

