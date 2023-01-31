package com.example.elearningproject;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.ResourceBundle;

public class CoursController implements Initializable {
    @FXML
    public ImageView html;
    @FXML
    public ImageView css;
    @FXML
    public ImageView java;
    @FXML
    public ImageView JS;
    @FXML
    public ImageView php;
    @FXML
    public MediaView vedeo;
    @FXML
    public Label course;
    @FXML
    public TextArea description;
    @FXML
    public MediaPlayer mediaPlayer;
    @FXML
    public JFXButton btnhome;
    @FXML
    public JFXButton btncss;
    @FXML
    public JFXButton btnjava;
    @FXML
    public JFXButton btJS;
    @FXML
    public JFXButton btnPhp;
    @FXML
    public JFXButton btnHtml;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          course.setText("home");
          description.setText("welcome to our plateforme");
        File file = new File("C:\\Users\\34697\\Downloads\\welcome.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);


        vedeo.setMediaPlayer(mediaPlayer);


    }
    @FXML

    public void playvedeo() {
        mediaPlayer.play();
    }

    @FXML
    public void pausevedeo() {
        mediaPlayer.pause();
    }

    @FXML
    public void getcourse(ActionEvent event) {

        String value=null;
        if(btncss.isFocused()){
            value=btncss.getText();
        }else if(btnjava.isFocused()){
            value=btnjava.getText();
        }else if(btnPhp.isFocused()){
            value=btnPhp.getText();
        }else if(btJS.isFocused()){
            value=btJS.getText();
        }else if(btnHtml.isFocused()){
            value=btnHtml.getText();
        }else if(btnhome.isFocused()){
            course.setText("home");
            description.setText("welcome to our plateforme");
            File file = new File("C:\\Users\\34697\\Downloads\\welcome.mp4");
            Media media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            vedeo.setMediaPlayer(mediaPlayer);
        }
        if(!btnhome.isFocused()) {
            course.setText(value);
            String[] info = new String[3];
            try {

                info = Client.getINFO(value);
                course.setText(info[0]);
                description.setText(info[1]);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            File file = new File(info[2]);
            Media media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);


            vedeo.setMediaPlayer(mediaPlayer);

        }
    }
}
