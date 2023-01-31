package com.example.elearningproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class registerController {
    @FXML
    private TextField name;

    @FXML
    private TextField password;
    @FXML
    private TextField email;

    public void OnInscrire() throws MalformedURLException, NotBoundException, RemoteException {
        String user=name.getText();
        String pass=password.getText();
        String emailS=email.getText();
        int res=Client.registerClient(user,pass,emailS);
        if(res==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "inscription réussi");
            alert.showAndWait();
        }

    }
}
