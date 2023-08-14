module com.mycompany.pruebaproyecto2p {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pruebaproyecto2p to javafx.fxml;
    exports com.mycompany.pruebaproyecto2p;
}
