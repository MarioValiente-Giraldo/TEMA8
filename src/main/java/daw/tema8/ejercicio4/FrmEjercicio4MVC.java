package daw.tema8.ejercicio4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FrmEjercicio4MVC {
    private int contador = 0;

    @FXML
    private Button btnPulsar;

    @FXML
    private Button btnReset;


    @FXML
    private Label lblMarcafor;

    @FXML

    void btnPulsar_pulsado(ActionEvent event) {
        btnReset.setDisable(false);
        contador++;
        lblMarcafor.setText(String.valueOf(contador));


    }

    @FXML
    void btnReset_pulsado(ActionEvent event) {
        contador = 0;
        lblMarcafor.setText(String.valueOf(contador));
        btnReset.setDisable(true);

    }

}

