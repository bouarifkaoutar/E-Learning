package com.example.elearningproject;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatroomController implements Initializable {
    @FXML
    public JFXButton nameClient;
    @FXML
    public Button btnsend;
    @FXML
    public TextField message;
    @FXML
    public TextArea boitemsg;
    @FXML
    public AnchorPane parent;

    @FXML
    public void send() throws MalformedURLException, SQLException, NotBoundException, RemoteException, ClassNotFoundException {
        Stage stage=(Stage) parent.getScene().getWindow();
        String user=stage.getTitle();

        Message msg=new Message(user,message.getText());
        Client.Send(msg);
        nameClient.setText(user);
        boitemsg.setText(user+":"+message.getText());

        message.clear();
    }
    public void getMessages() throws MalformedURLException, SQLException, NotBoundException, RemoteException, ClassNotFoundException {
        ArrayList<Message> msgs=new ArrayList<>();
        msgs=Client.getAllMessages();
        for( Message msg : msgs){
            boitemsg.setText(msg.getMsg()+"/n");


        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getMessages();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
