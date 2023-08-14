module com.pooespol.proyecto_2p_poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.proyecto_2p_poo to javafx.fxml;
    exports com.pooespol.proyecto_2p_poo;
}
