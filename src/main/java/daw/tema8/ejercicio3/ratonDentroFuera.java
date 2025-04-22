package daw.tema8.ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;

public class ratonDentroFuera {

    @FXML
    private Label lblRaton;

    @FXML
    void lblRaton_dentro(MouseEvent event) {
        lblRaton.setText("El ratón está dentro");
        lblRaton.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,null,null)));
    }

    @FXML
    void lblRaton_fuera(MouseEvent event) {
        lblRaton.setText("El ratón está fuera");
        lblRaton.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,null,null)));


    }

}

