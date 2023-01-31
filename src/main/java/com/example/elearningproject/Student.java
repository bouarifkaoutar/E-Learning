package com.example.elearningproject;

import java.io.Serializable;

public class Student implements Serializable {
      int id_Student ;
     String Nom ;
     String email ;

    public Student(int id,String name,String email) {
        this.id_Student = id;
        this.Nom=name;
        this.email=email;
    }

    public int getId_Student() {
        return id_Student;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return Nom;
    }
}
