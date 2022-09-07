package com.revature.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn;

    private ConnectionUtil(){
        conn = null;
    }

    public static Connection getConnection(){
        try{
            if(conn != null && !conn.isClosed()){
                return conn;
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        String url,user,pass;
        Properties prop = new Properties();

        try {
            Class.forName("org.postgresql.Driver");

            prop.load(new FileReader("/home/trenton/main/Revature/rest/src/main/resources/database.properties"));
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            pass = prop.getProperty("pass");

            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
