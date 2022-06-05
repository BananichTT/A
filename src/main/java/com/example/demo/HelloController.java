package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    @FXML
    protected void onHelloButtonClick() {

        if (login.getText().isBlank() == false && password.getText().isBlank() == false){
            validation();
        }

    }

    public void validation(){
        DBConnector connectNow = new DBConnector();
        Connection connectionDB = connectNow.getConnection();

        String loginQuery = "SELECT count(1) FROM Test where name = '" + login.getText() + "' AND pass = '" + password.getText() + "'";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOut = statement.executeQuery(loginQuery);

            while (queryOut.next()){
              if (queryOut.getInt(1) == 1){
                  System.out.println("success");
              }else{
                  System.out.println("error");
              }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}