module com.example.elgenesis {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.elgenesis to javafx.fxml;
    exports com.example.elgenesis;
}