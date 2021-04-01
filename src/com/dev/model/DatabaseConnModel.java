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
    //Add GPU
    private String GPUName;
    private String GPUPrice;
    //Remove GPU
    private String GPU;
    //Show Additional Error
    private String GPUInfo = "";
    //Get All GPU
    private String gDBAppendedData = "";
    private String gDBAppendedDataTwo = "";

    //Mutator Method

    public void setgDBAppendedDataTwo(String gDBAppendedDataTwo) {
        this.gDBAppendedDataTwo = gDBAppendedDataTwo;
    }
    public void setgDBAppendedData(String gDBAppendedData) {
        this.gDBAppendedData = gDBAppendedData;
    }
    public String getgDBAppendedData(){
        return gDBAppendedData;
    }
    public String getgDBAppendedDataTwo() {
        return gDBAppendedDataTwo;
    }
    public String getGPUInfo() {
        return GPUInfo;
    }
    public String getSQLString() {
        return SQLString;
    }
    public void setGPUInfo(String GPUInfo) {
        this.GPUInfo = GPUInfo;
    }
    public void setGPUName(String gNamex) {
        this.GPUName = gNamex;
    }
    public void setGPUPrice(String GPUPrice) {
        this.GPUPrice = GPUPrice;
    }
    public void setGPU(String GPU) {
        this.GPU = GPU;
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

    public DatabaseConnModel(){
    }

    public void SQLConn(int Query, boolean SQLConn) throws SQLException {

        switch (Query) {
            case 1:
                setSQLString("INSERT INTO isdbase.gpu (name, price) VALUES (?, ?)");
                break;
            case 2:
                setSQLString("SELECT * FROM isdbase.gpu");
                break;
            case 3:
                setSQLString("DELETE from isdbase.gpu WHERE name = ?");
                break;
            case 4:
                setSQLString("SELECT * FROM isdbase.users WHERE binary loginid = ? and binary password = ?");
                break;
            case 5:
                setSQLString("SELECT g.id, g.name, g.price, i.stocks, m.oem_manufacturer FROM isdbase.gpu as g INNER JOIN inventory i on g.id = i.id INNER JOIN isdbase.manufacturer as m on i.manufacturer = m.oem_manufacturer");
            default:
                break;
        }

        /**
         * NOTES BY: FRANCIS MICO A. ROSARIO ID#11846551
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
                            ":" + portNumber + "/isdbase",
                    connectionProps);
            String SQLQuery = getSQLString();
            //Primary Query
            PreparedStatement stmt = conn.prepareStatement(SQLQuery);
            //Secondary Query
            PreparedStatement stmt2 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=OFF");
            /**
             * This part will use a switch statement to check and perform the selected SQL Query;
             */
            switch (getSQLString()) {
                case "SELECT * FROM isdbase.users WHERE binary loginid = ? and binary password = ?": {
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
                case "INSERT INTO isdbase.gpu (name, price) VALUES (?, ?)": {
                    stmt.setString(1, GPUName);
                    stmt.setString(2, GPUPrice);
                    int result = stmt.executeUpdate();
                    System.out.println();
                    if (result > 0) {
                        System.out.println("Add GPU Success!");
                    } else {
                        System.out.println("Add GPU Failed!");
                    }
                    break;
                }
                case "DELETE from isdbase.gpu WHERE name = ?": {
                    stmt2.execute();
                    stmt.setString(1, GPU);
                    int result = stmt.executeUpdate();
                    System.out.println();
                    if (result > 0) {
                        System.out.println("GPU " + GPU + " have been deleted.");
                        setGPUInfo("<b><p>GPU " + GPU + " Have been deleted, Click the Return Button.</b></p>");
                    } else {
                        setGPUInfo("<b><p>GPU " + GPU + " Have not been removed / Unidentified Problem Occurred, Click the Return Button.</b></p>");
                        System.out.println("Error Occurred");
                    }
                    break;

                }
                case "SELECT * FROM isdbase.gpu": {
                    ResultSet result = stmt.executeQuery();
                    StringBuilder builder = new StringBuilder();
                    while (result.next()) {
                        String gPM = result.getString("id");
                        String gName = result.getString("name");
                        String gPrice = result.getString("price");
                        System.out.println();
                        builder.append("<tr><td>").append(gPM).append("</td><td>").append(gName).append("</td><td>").append(gPrice).append(" PHP").append("</td></tr>");
                        String AppendedDBGPU = builder.toString();
                        setgDBAppendedData(AppendedDBGPU);
                    }
                    break;
                }
                case "SELECT g.id, g.name, g.price, i.stocks, m.oem_manufacturer FROM isdbase.gpu as g INNER JOIN inventory i on g.id = i.id INNER JOIN isdbase.manufacturer as m on i.manufacturer = m.oem_manufacturer": {
                    ResultSet result = stmt.executeQuery();
                    StringBuilder builderTwo = new StringBuilder();
                    while(result.next()){
                        String GPUid = result.getString("id");
                        String GPUNameDB = result.getString("name");
                        String GPUPriceDB = result.getString("price");
                        String GPUStocksDB = result.getString("stocks");
                        String GPUOEMDB = result.getString("oem_manufacturer");
                        builderTwo.append("<tr><td>").append(GPUid).append("</td><td>").append(GPUNameDB).append("</td><td>").append(GPUPriceDB).append(" PHP").append("</td><td>").append(GPUStocksDB).append("</td><td>").append(GPUOEMDB).append("</td></tr>");
                        String AppendedDBGPUTwo = builderTwo.toString();
                        setgDBAppendedDataTwo(AppendedDBGPUTwo);
                    }
                    break;
                }
            }
        }else{
            System.out.println("SQL Connection is set to False");
        }
    }

}

