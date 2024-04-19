module org.immigration.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports org.immigration.project;
    opens org.immigration.project to javafx.fxml;
}