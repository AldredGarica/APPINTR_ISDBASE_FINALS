package com.dev.model;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnModel {

    private final Object userName = "newuser";
    private final Object password = "password";
    private String SQLString = "";

    //Username, Password and Boolean
    private String usernamex;
    private String passwordx;
    private boolean loginAccepted = false;
    //Add Guitar
    private String gName;
    private String gPrice;
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


    //Init
    public DatabaseConnModel(){
    }

    public void SQLConn() throws SQLException {

        Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        String dbms = "mysql";
        String serverName = "0.tcp.ap.ngrok.io";
        int portNumber = 15057;
        conn = DriverManager.getConnection(
                "jdbc:" + dbms + "://" +
                        serverName +
                        ":" + portNumber + "/",
                connectionProps);
        String SQLQuery = getSQLString();

        switch (getSQLString()) {
            case "SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?": {
                //assert conn != null : "Check SQLConn";
                PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
                stmtx.setString(1, usernamex);
                stmtx.setString(2, passwordx);
                ResultSet result = stmtx.executeQuery();
                if (result.next()) {
                    System.out.println();
                    System.out.println("Username(ColumnIndex#2): " + result.getString(2));
                    System.out.println("Password(ColumnIndex#3): " + result.getString(3));
                    setLoginAccepted(true);
                } else {
                    System.out.println();
                    System.out.println("Incorrect Username / Password");
                }
                break;
            }
            case "INSERT INTO finals.guitars (gName, gPrice) VALUES (?, ?)": {
                PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
                stmtx.setString(1, gName);
                stmtx.setString(2, gPrice);
                int result = stmtx.executeUpdate();
                System.out.println();
                if (result > 0) {
                    System.out.println("Add Guitar Success!");
                } else {
                    System.out.println("Add Guitar Failed!");
                }
                break;
            }
            case "DELETE from finals.guitars WHERE gName = ?": {
                PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
                stmtx.setString(1, rGuitar);
                int result = stmtx.executeUpdate();
                System.out.println();
                if (result > 0) {
                    System.out.println("Guitar " + rGuitar + " have been deleted.");
                    setrGuitarInfo("<b><p>Guitar " + rGuitar + " Have been deleted, Click the Return Button.</b></p>");
                } else {
                    setrGuitarInfo("<b><p>Guitar " + rGuitar + " Have not been removed / Unidentified Problem Occurred, Click the Return Button.</b></p>");
                    System.out.println("Error Occurred");
                }
                break;
            } case "SELECT * FROM finals.guitars": {
                PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
                ResultSet result = stmtx.executeQuery();
                StringBuilder builder = new StringBuilder();
                while ( result.next() ) {
                    String gPM = result.getString("id");
                    String gName = result.getString("gName");
                    String gPrice = result.getString("gPrice");
                    System.out.println();
                    builder.append("<tr><td>").append(gPM).append("</td><td>").append(gName).append("</td><td>").append(gPrice).append(" PHP").append("</td></tr>");
                    String AppendedDBGuitars = builder.toString();
                    setgDBAppendedData(AppendedDBGuitars);
            }
                break;
        }
        }
    }

    public void CheckLogin(){
        setSQLString("SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?");
    }
    public void AddGuitar(){
        setSQLString("INSERT INTO finals.guitars (gName, gPrice) VALUES (?, ?)");
    }
    public void getDBGuitars(){
        setSQLString("SELECT * FROM finals.guitars");
    }

    public void RemoveGuitar(){
        setSQLString("DELETE from finals.guitars WHERE gName = ?");
    }


}

