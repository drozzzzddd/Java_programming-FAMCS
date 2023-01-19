module com.example.table {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.table to javafx.fxml;
    exports com.example.table;
}