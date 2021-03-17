package com.dev.model;

import java.sql.*;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.IOException;

public class DatabaseConnModel {

    /**SQL Connection (REMOTE)**/
    private String dbms = "mysql";
    private Object userName = "newuser";
    private String serverName = "0.tcp.ap.ngrok.io";
    private int portNumber = 15057;
    private String dbName = "finals";
    private String password = "password";
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
    //Mutator Method


    public void setrGuitarInfo(String rGuitarInfo) {
        this.rGuitarInfo = rGuitarInfo;
    }

    public String getrGuitarInfo() {
        return rGuitarInfo;
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
    public String getrGuitar() {
        return rGuitar;
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
    public String getSQLString() {
        return SQLString;
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

    public Connection SQLConn() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/",
                    connectionProps);
        }
       String SQLQuery = getSQLString();

        if(getSQLString().equals("SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?")) {
            //assert conn != null : "Check SQLConn";
            PreparedStatement stmt = conn.prepareStatement(SQLQuery);
            stmt.setString(1, usernamex);
            stmt.setString(2, passwordx);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                System.out.println("Username(ColumnIndex#2): " + result.getString(2));
                System.out.println("Password(ColumnIndex#3): " + result.getString(3));
                setLoginAccepted(true);
            } else {
                System.out.println("Incorrect Username / Password");
            }
        }else if(getSQLString().equals("INSERT INTO finals.guitars (gName, gPrice) VALUES (?, ?)")){
            PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
            stmtx.setString(1, gName);
            stmtx.setString(2, gPrice);
            int result = stmtx.executeUpdate();
            if (result > 0) {
                System.out.println("Add Guitar Success!");
            }else {
                System.out.println("Add Guitar Failed!");
            }
        }else if(getSQLString().equals("DELETE from finals.guitars WHERE gName = ?")){
            PreparedStatement stmtx = conn.prepareStatement(SQLQuery);
            stmtx.setString(1, rGuitar);
            int result = stmtx.executeUpdate();
            if (result > 0) {
                System.out.println("Guitar " + rGuitar + " have been deleted.");
                setrGuitarInfo("<b><p>Guitar " +  rGuitar + " Have been deleted, Click the Return Button.</b></p>");
            }else {
                setrGuitarInfo("<b><p>Guitar " +  rGuitar + " Have not been removed / Unidentified Problem Occurred, Click the Return Button.</b></p>");
                System.out.println("Error Occurred");
            }
        }
        return conn;
    }

    public void CheckLogin(){
        setSQLString("SELECT * FROM finals.users WHERE binary loginid = ? and binary password = ?");
    }
    public void AddGuitar(){
        setSQLString("INSERT INTO finals.guitars (gName, gPrice) VALUES (?, ?)");
    }

    public void RemoveGuitar(){
        setSQLString("DELETE from finals.guitars WHERE gName = ?");
    }


}

