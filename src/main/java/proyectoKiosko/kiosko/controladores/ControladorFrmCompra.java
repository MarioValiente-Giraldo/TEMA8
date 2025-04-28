package proyectoKiosko.kiosko.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import proyectoKiosko.kiosko.modelo.Carrito;
import proyectoKiosko.kiosko.modelo.Producto;
import proyectoKiosko.kiosko.vistas.CeldaImagen;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorFrmCompra implements Initializable {
    private Carrito carrito;
    public void setCarrito(Carrito carrito){
        this.carrito = carrito;
        this.tabCompra.getItems().addAll(this.carrito.getProductos());
    }
    private void configurarColumnasTabla(){
        this.colNombre.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().nombre()));
        this.colPrecio.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().precio()));
        colProducto.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().imagen()));
        colProducto.setCellFactory(columna -> new CeldaImagen());
    }

    @FXML
    private Button btnConfirmarCompra;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto, Image> colProducto;

    @FXML
    private TableView<Producto> tabCompra;
    @FXML
    void btnConfirmarCompra_pulsado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,this.carrito.getPrecio()+"€ en total");
        alert.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.configurarColumnasTabla();
    }
}


