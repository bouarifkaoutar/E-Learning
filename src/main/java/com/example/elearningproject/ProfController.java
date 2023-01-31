package com.example.elearningproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfController {

    @FXML
    public  Button JS;
    @FXML
    public Button btnHtml;
    @FXML
    public Button btnCss;
    @FXML
    public Button java;
    @FXML
    public Button Php;


    @FXML
    public void GETstudents() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("Students.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage=new Stage();

        stage.setTitle("Students");
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    public void getCourse() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("FicheCours.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage=new Stage();

        stage.setTitle("course");
        stage.setScene(scene);
        stage.show();
    }



    }

