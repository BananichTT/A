package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    public Connection databaseLink;
    public Connection getConnection(){
        String DBName = "DemoTest";
        String DBUser = "root";
        String DBPassword = "root";
        String url = "jdbc:mysql://localhost/" + DBName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, DBUser, DBPassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
