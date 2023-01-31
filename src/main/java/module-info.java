module com.example.elearningproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.rmi;
    requires javafx.media;
    requires com.jfoenix;


    opens com.example.elearningproject to javafx.fxml;
    exports com.example.elearningproject;
}