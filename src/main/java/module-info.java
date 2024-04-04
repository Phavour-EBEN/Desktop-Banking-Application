module com.example.prototype_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prototype_2 to javafx.fxml;
    exports com.example.prototype_2;
}