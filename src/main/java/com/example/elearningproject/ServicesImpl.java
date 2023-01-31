package com.example.elearningproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesImpl extends UnicastRemoteObject implements Services,Serializable {
    private static  final long serialVersionUID= 1L;
    static ArrayList<Student>  StudentList ;
    static  ArrayList<Message>  Messages=new ArrayList<>();
    public ServicesImpl() throws RemoteException {
    super();
    }

    public String login(String username, String password) throws SQLException, ClassNotFoundException {
        String result=Connexion.VerifyLogin(username,password);
        return  result;

    }
    public int  Register(String username, String password,String email) throws RemoteException, SQLException, ClassNotFoundException{
        int res=Connexion.register(username,password,email);
        return res;

    }
    public ArrayList<Student> SetStudentTable() throws RemoteException, SQLException, ClassNotFoundException {
        StudentList=Connexion.SetElementTable();
        return StudentList;
    };
    public String[] GETInfoCourses(String Course)throws RemoteException, SQLException, ClassNotFoundException{
      String[] info=Connexion.GETinfoCourses(Course);
      return info;
    }
    public void sendMessage(Message msg)throws RemoteException, SQLException, ClassNotFoundException{
        Messages.add(msg);
    }
    public ArrayList<Message> getMessages() throws  RemoteException,SQLException, ClassNotFoundException{
        return Messages;
    }

}
