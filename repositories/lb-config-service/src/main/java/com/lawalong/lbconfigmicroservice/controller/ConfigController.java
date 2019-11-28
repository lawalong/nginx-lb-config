package com.lawalong.lbconfigmicroservice.controller;

import com.lawalong.lbconfigmicroservice.model.Treasure;
import com.lawalong.lbconfigmicroservice.util.ConfigFileReader;
import com.lawalong.lbconfigmicroservice.util.FileIO;
import com.lawalong.lbconfigmicroservice.util.TreasureEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequestMapping("/")
public class ConfigController {

    @Autowired
    private Treasure treasure; // init Data
    private String STR_DENYALL = "deny all;";

    // Index
    @GetMapping("/") //default: localhost:8080/
    public String sayHello() {

        return ConfigFileReader.GetBlockListSimpleHTMLResponse(treasure.getBLACKLIST_FILE_PATH());

    }



    // Set Access On
    @GetMapping("/access-on")
    public void switchOffAccess(HttpServletResponse httpResponse) throws Exception {

        FileIO fileIO = new FileIO();
        fileIO.writeUsingFiles(treasure.getBLACKLIST_FILE_PATH(),"");

        httpResponse.sendRedirect("/");

    }

    // Set Access Off
    @GetMapping("/access-off")
    public void turnOnAccess(HttpServletResponse httpResponse) throws Exception {

        FileIO fileIO = new FileIO();
        fileIO.writeUsingFiles(treasure.getBLACKLIST_FILE_PATH(),STR_DENYALL);

        httpResponse.sendRedirect("/");

    }




}

