package com.lawalong.lbconfigmicroservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component("treasure")
@PropertySource("classpath:treasure.properties")
@XmlRootElement
public class Treasure {
    String BLACKLIST_FILE_PATH;
    String API_KEY;
    String KEY;
    String SALT;



    public Treasure() {
        // TODO Auto-generated constructor stub
    }

    @Autowired
    public Treasure(Environment env){
        System.out.println("Server bean Creation...");
        setBLACKLIST_FILE_PATH(env.getProperty("BLOCKLIST_FILE_PATH"));
        setAPI_KEY(env.getProperty("API_KEY"));
        setKEY(env.getProperty("KEY"));
        setSALT(env.getProperty("SALT"));
        System.out.println(this.toString());

    }

    public String getBLACKLIST_FILE_PATH() {
        return BLACKLIST_FILE_PATH;
    }

    public void setBLACKLIST_FILE_PATH(String BLACKLIST_FILE_PATH) {
        this.BLACKLIST_FILE_PATH = BLACKLIST_FILE_PATH;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public String getSALT() {
        return SALT;
    }

    public void setSALT(String SALT) {
        this.SALT = SALT;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return BLACKLIST_FILE_PATH+"|"+API_KEY+"|"+KEY;    }
}
