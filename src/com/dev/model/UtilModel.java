package com.dev.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtilModel {

    public UtilModel(){

    }

    public static String myPublicIp() {

        String ipAdressDns  = "";
        try {
            String command = "nslookup myip.opendns.com resolver1.opendns.com";
            Process proc = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String s;
            while ((s = stdInput.readLine()) != null) {
                ipAdressDns  += s + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ipAdressDns ;
    }

}
