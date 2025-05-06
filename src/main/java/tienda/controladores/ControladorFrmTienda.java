package tienda.controladores;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tienda.modelo.Producto;
import tienda.modelo.ProductoRepository;
import tienda.modelo.ProductoService;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorFrmTienda implements Initializable {

    private ProductoService service;
    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnTasar;

    @FXML
    private TableColumn<Producto, String> colID;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Boolean> colTasable;

    @FXML
    private TableColumn<Producto, Integer> colUnidades;

    @FXML
    private TableView<Producto> tabTienda;

    @FXML
    void btnAñadir_pulsado(ActionEvent event) {
        this.service.añadirUnidad(this.tabTienda.getSelectionModel().getSelectedItem());
        this.rellenarTabla();
    }

    @FXML
    void btnTasar_pulsado(ActionEvent event) {
       Producto producto = this.tabTienda.getSelectionModel().getSelectedItem();
        if (producto.isTasable()){
            this.service.noTasar(producto);
        }else {
            this.service.tasar(producto);
        }
        rellenarTabla();
    }
    public void rellenarTabla(){
        this.tabTienda.getItems().clear();
        this.tabTienda.getItems().addAll(this.service.consultarPorductos());
        this.colID.setCellValueFactory(fila->new SimpleObjectProperty<>(fila.getValue().getId()));
        this.colNombre.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getNombre()));
        this.colPrecio.setCellValueFactory(fila->new SimpleObjectProperty<>(fila.getValue().getPrecio()));
        this.colUnidades.setCellValueFactory(fila->new SimpleObjectProperty<>(fila.getValue().getUnidades()));
        this.colTasable.setCellValueFactory(fila->new SimpleObjectProperty<>(fila.getValue().isTasable()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.service = new ProductoService();

        this.rellenarTabla();

    }
}

