package com.dev.model;

import java.sql.*;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.IOException;

public class model{

    //SQL LOGIN
    private String dbms = "mysql";
    private Object userName = "newuser";
    private String serverName = "0.tcp.ap.ngrok.io";
    private int portNumber = 15057;
    private String dbName = "finals";
    private String password = "password";
    //OTHERS
    private String usernamex;
    private String passwordx;
    private boolean loginAccepted = false;

    //GETTERS AND SETTERS
    public void setPasswordx(String passwordx) {
        this.passwordx = passwordx;
    }

    public void setUsernamex(String usernamex) {
        this.usernamex = usernamex;
    }

    public boolean isLoginAccepted() {
        return loginAccepted;
    }

    public model(){
    }

    public Connection getConnection() throws SQLException {

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
        System.out.println("Connected to database");

        String CheckLogin = "SELECT * FROM finals.users WHERE loginid = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(CheckLogin);
        stmt.setString(1, usernamex);
        stmt.setString(2, passwordx);
        ResultSet result = stmt.executeQuery();
        if(result.next()){
            System.out.println("USERNAME: " + result.getString(2));
            System.out.println("PASSWORD: " + result.getString(3));
            loginAccepted = true;
        }else{
            System.out.println("INCORRECT USERNAME / PASSWORD");
        }

        return conn;
    }


}

