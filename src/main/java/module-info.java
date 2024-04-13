module org.immigration.project.approverFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.immigration.project to javafx.fxml;
    exports org.immigration.project;
}