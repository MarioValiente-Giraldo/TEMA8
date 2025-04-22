package daw.tema8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class controladorEjemplo1MVC {

    @FXML
    private Button btnMostrar;

    @FXML
    void btnMostrar_pulsado(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION,"Hola Mundo");
        alerta.show();
    }

}

