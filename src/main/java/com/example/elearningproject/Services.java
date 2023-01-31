package com.example.elearningproject;

import javafx.collections.ObservableList;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Services extends Remote{
    public String login(String username, String password) throws RemoteException, SQLException, ClassNotFoundException;
    public int  Register(String username, String password,String email) throws RemoteException, SQLException, ClassNotFoundException;
    public ArrayList<Student> SetStudentTable() throws  RemoteException,SQLException, ClassNotFoundException ;
    public String[] GETInfoCourses(String Course)throws RemoteException, SQLException, ClassNotFoundException;
    public void sendMessage(Message msg)throws RemoteException, SQLException, ClassNotFoundException;
    public ArrayList<Message> getMessages() throws  RemoteException,SQLException, ClassNotFoundException ;
}
