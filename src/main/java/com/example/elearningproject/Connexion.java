package com.example.elearningproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.net.DatagramPacket;
import java.sql.*;
import java.util.ArrayList;

public class Connexion {
    static String user = "";
    static String password = "";
    static String url = "jdbc:mysql://localhost/test2";
    static String driver = "com.mysql.jdbc.Driver";
    static String sql;
    static ResultSet rs;
    static ResultSet rs1;
    static  ArrayList<Student> StudentList;

    static Statement stmt = null;
    static Connection conn=null;

    public static void Connection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection("jdbc:mysql://localhost/test2", "root", "");

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException var1) {

            var1.printStackTrace();


        }}

    public static String VerifyLogin( String nom,String password) throws SQLException, ClassNotFoundException {
        Connexion.Connection();
           sql = "SELECT nom,password FROM  students WHERE  nom='" + nom + "' and password= '" + password + "'";
       Connexion.stmt = conn.createStatement();
        Connexion.rs = Connexion.stmt.executeQuery(Connexion.sql);

        if (Connexion.rs.next()) {
            Connexion.conn.close();
            Connexion.stmt.close();
          return "true";

        } else {
            Connexion.conn.close();
            Connexion.stmt.close();
            return "false";

        }

    }
    public static  int register(String nom,String password,String email) throws SQLException, ClassNotFoundException {
        Connexion.Connection();
       sql = "INSERT INTO `students` (`nom`, `password`,`email`) VALUES ('" + nom + "','" + password + "','" + email+ "')";
        stmt = Connexion.conn.createStatement();
       int res=stmt.executeUpdate(Connexion.sql);

        Connexion.conn.close();
        Connexion.stmt.close();
        return res;
    }
    public static ArrayList<Student> SetElementTable() throws SQLException, ClassNotFoundException {
        Connexion.Connection();
        StudentList=new ArrayList<>();
        sql= "SELECT id_Student,Nom,email FROM  `students`";
        Connexion.stmt = conn.createStatement();
        Connexion.rs = Connexion.stmt.executeQuery(Connexion.sql);

        while (rs.next()){
            StudentList.add(new  Student(
                    Connexion.rs.getInt(1),
                    Connexion.rs.getString(2),
                    Connexion.rs.getString(3)));
        }

        Connexion.conn.close();
        Connexion.stmt.close();
        return StudentList;
    }
    public static  String[] GETinfoCourses(String NomCourse) throws SQLException, ClassNotFoundException {
        Connexion.Connection();
        sql="SELECT Nom_C,description,vedeo from `course` WHERE  Nom_C='" + NomCourse + "'";
        Connexion.stmt = conn.createStatement();
        Connexion.rs = Connexion.stmt.executeQuery(Connexion.sql);
        String[] Info = new String[3];
        if(rs.next()){
            Info[0]=Connexion.rs.getString(1);
            Info[1]=Connexion.rs.getString(2);
            Info[2]=Connexion.rs.getString(3);
        }
        return Info;
    }
}
