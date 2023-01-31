package com.example.elearningproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {
   static String Url="rmi://localhost/remote";
    static  ArrayList<Student> StudentList;
public static  String LoginClient(String name,String password) throws MalformedURLException, NotBoundException, RemoteException {

    Services od=(Services) Naming.lookup(Url);
    String res="false";
    try {
       res=od.login(name,password);

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();

    }
    return  res;

}
public static int  registerClient(String name,String password,String email) throws MalformedURLException, NotBoundException, RemoteException {


    Services od=(Services) Naming.lookup(Url);
    int res=0;
    try {
        res=od.Register(name,password,email);

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return res;

}
public static ArrayList<Student> SETSTUDENT() throws MalformedURLException, NotBoundException, RemoteException {

    Services od=(Services) Naming.lookup(Url);

    try {
       Client.StudentList=od.SetStudentTable();
       return Client.StudentList;
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}
public static  String[] getINFO(String Course) throws MalformedURLException, NotBoundException, RemoteException, SQLException, ClassNotFoundException {
    Services od=(Services) Naming.lookup(Url);

      String[] info=od.GETInfoCourses(Course);
    return info;

}
public static void Send(Message msg) throws SQLException, RemoteException, ClassNotFoundException, MalformedURLException, NotBoundException {
    Services od=(Services) Naming.lookup(Url);

    od.sendMessage(msg);

}
 public static  ArrayList<Message> getAllMessages() throws SQLException, RemoteException, ClassNotFoundException, MalformedURLException, NotBoundException{
    ArrayList<Message> msgs=new ArrayList<>();
    Services od=(Services) Naming.lookup(Url);
    msgs=od.getMessages();
    return msgs;

 }


}
