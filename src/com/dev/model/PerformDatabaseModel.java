package com.dev.model;
import java.sql.*;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.IOException;

public class PerformDatabaseModel {

    //SQL LOGIN
    private String dbms = "mysql";
    private Object userName = "newuser";
    private String serverName = "0.tcp.ap.ngrok.io";
    private int portNumber = 15057;
    private String dbName = "finals";
    private String password = "password";

    public PerformDatabaseModel(){

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

        return conn;
    }

}
