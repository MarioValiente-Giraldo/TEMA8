package proyectoKiosko.kiosko.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoKiosko.kiosko.modelo.Carrito;
import proyectoKiosko.kiosko.modelo.Producto;
import proyectoKiosko.kiosko.modelo.ProductoRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorFrmVenta implements Initializable {
    private Carrito carrito;
    @FXML
    private Button btnAñadirTodo;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnQuitarTodo;

    @FXML
    private Button btnQuitarUnidad;

    @FXML
    private Button btnUnidadAñadir;

    @FXML
    private ListView<Producto> lstCarrito;

    @FXML
    private ListView<Producto> lstProductos;

    @FXML
    private Text txtCarrito;

    @FXML
    private Text txtProductos;

    @FXML
    void btnAñadirTodo_pulsado(ActionEvent event) {
        List<Producto> productos = this.lstProductos.getItems();
        this.lstCarrito.getItems().addAll(productos);
        for (Producto x : productos){
            this.carrito.añadir(x);
        }
        this.lstProductos.getItems().removeAll(productos);

    }

    @FXML
    void btnComprar_pulsado(ActionEvent event) {
        Stage ventana = (Stage) this.btnComprar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("frmCompra.fxml"));
        try {
            Scene escenaCompra = new Scene(fxmlLoader.load());
            ControladorFrmCompra controladorFrmCompra = fxmlLoader.getController();
            controladorFrmCompra.setCarrito(this.carrito);
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(ventana);
            stage.setTitle("Confirmar compra");
            stage.setScene(escenaCompra);
            stage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void btnQuitarTodo_pulsado(ActionEvent event) {
        List<Producto> productos = this.lstCarrito.getItems();
        this.lstProductos.getItems().addAll(productos);
        for (Producto x : productos){
            this.carrito.retirar(x);
        }
        this.lstCarrito.getItems().removeAll(productos);
    }

    @FXML
    void btnQuitarUnidad_pulsado(ActionEvent event) {
        Producto p = this.lstCarrito.getSelectionModel().getSelectedItem();
        if (p!=null) {
            this.lstProductos.getItems().add(p);
            this.carrito.retirar(p);
            this.lstCarrito.getItems().remove(p);
        }
    }

    @FXML
    void btnUnidadAñadir_pulsado(ActionEvent event) {
        Producto p = this.lstProductos.getSelectionModel().getSelectedItem();
        if (p!=null) {
            this.lstCarrito.getItems().add(p);
            this.carrito.añadir(p);
            this.lstProductos.getItems().remove(p);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProductoRepository productoRepository = new ProductoRepository();
        this.lstProductos.getItems().addAll(productoRepository.consultarProductos());
        this.carrito = new Carrito();
    }
}

