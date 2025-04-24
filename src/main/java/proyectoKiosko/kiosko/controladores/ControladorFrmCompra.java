package proyectoKiosko.kiosko.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorFrmCompra {

    @FXML
    private Button ConfirmarCompra;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private TableColumn<?, ?> colProducto;

    @FXML
    private TableView<?> tabCompra;

}


