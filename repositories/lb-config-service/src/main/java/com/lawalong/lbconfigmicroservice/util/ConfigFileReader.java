package com.lawalong.lbconfigmicroservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ConfigFileReader {

    /**
     * Get a simple HTML page with BlackList status
     * @return
     */
    public static String GetBlockListSimpleHTMLResponse(String filePath){
        File tmpDir = new File(filePath); // check if unapplied config file exit
        boolean exists = tmpDir.exists();

        String applyStatus = "Applied";

        if(exists)
            applyStatus = "Not Applied";

        StringBuilder sb = new StringBuilder();

        sb.append("<h1>Load Balancer BlackList</h1>")
                .append("<br>")
                .append("Curent Value: ")
                .append("<b><font color='red'>") // text-color,style
                .append(ReadBlackIPList(filePath))
                .append("</font></b><br>")
                .append("<br>")
                .append("Apply Status: ")
                .append("<b><font color='red'>") // text-color,style
                .append(applyStatus)
                .append("</font></b><br>")
                .append("<br>")
                .append("<a href='javascript:window.location.reload(true)'>Refresh</a><br>") // Button refresh
                .append("<a href='/access-off'>Turn Off</a><br>") // Button turn off
                .append("<a href='/access-on'>Turn On</a>"); // Button turn on

        return sb.toString();
    }


    /**
     * This method read Black IP List Config File
     *
     * @return state code 1 = success, ..
     */
    private static String ReadBlackIPList(String filePath){


        File tmpDir = new File(filePath); // check if unapplied config file exit
        boolean exists = tmpDir.exists();

        if(!exists)
            filePath = filePath.replace("_new",""); // read lived config file

        String line = "";
        String tempstr = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {
                tempstr = line;

                // Need further develop: Read file to a arr ,then return



            }

            return tempstr;

        } catch (Exception e) {
            System.out.println(e);
            return e.toString(); // simple error code, it would be more code to handle different exception in development env
        }


    }




}
