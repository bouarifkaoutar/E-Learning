package com.example.elearningproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentsController  implements Initializable{

    @FXML
    private TableView<Student> students=new TableView<>();
    @FXML
    private TableColumn<Student, Integer> ID;
    @FXML
    private TableColumn<Student, String> Nom;
    @FXML
    private TableColumn<Student, String> email;

    @FXML
    private TextField name;

    @FXML
    private TextField password;
    @FXML
    private TextField emailS;
      ArrayList<Student> student=new ArrayList<>();



    @FXML
    public void ActualiserTable() throws MalformedURLException, NotBoundException, RemoteException {
        student = Client.SETSTUDENT();

        ObservableList<Student> StudentList = FXCollections.observableArrayList(student);
        ID.setCellValueFactory(new PropertyValueFactory<>("id_Student"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        students.setItems(StudentList);

    }
    @FXML
    public void  AjouterStudent() throws MalformedURLException, NotBoundException, RemoteException {
        String Nom=name.getText();
        String pass=password.getText();
        String email=emailS.getText();
        Client.registerClient(Nom,pass,email);
        ActualiserTable();
        name.clear();
        password.clear();
        emailS.clear();

    }




    @FXML
   public void GetData(){


   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        }

    @FXML
    public void goBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("Prof.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage=new Stage();

        stage.setTitle("Enseignant");
        stage.setScene(scene);
        stage.show();
    }
}


