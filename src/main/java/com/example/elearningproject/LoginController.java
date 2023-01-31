package com.example.elearningproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginController  {
    @FXML
     private TextField username;

    @FXML
    private TextField password;

    @FXML
    public  void login() throws IOException, NotBoundException {
    String user=username.getText();
    String pass=password.getText();
    if(user.equals("Enseignant") && pass.equals("0000")){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("Prof.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage=new Stage();

        stage.setTitle("Enseignant");
        stage.setScene(scene);
        stage.show();
    }else {
        String res = Client.LoginClient(user, pass);

       if(res.equals("true")) {
           /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Succes");
           alert.showAndWait();*/
           FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("ChatRoom.fxml"));
           Scene scene = new Scene(fxmlLoader.load(), 700, 600);
           Stage stage=new Stage();

           stage.setTitle(user);
           stage.setScene(scene);
           stage.show();

       }else{
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "failed");
           alert.showAndWait();
       }}
    }

    public void register() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage=new Stage();

        stage.setTitle("register");
        stage.setScene(scene);
        stage.show();
    }
}


