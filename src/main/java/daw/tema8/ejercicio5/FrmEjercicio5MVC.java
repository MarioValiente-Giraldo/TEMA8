package daw.tema8.ejercicio5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FrmEjercicio5MVC  implements Initializable {

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnSeleccionar;

    @FXML
    private ComboBox<Alumno> cmbAlumnos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNota;

    @FXML
    void btnBorrar_pulsado(ActionEvent event) {
        this.txtNombre.clear();
        this.txtNota.clear();
        this.cmbAlumnos.getSelectionModel().clearSelection();
    }

    @FXML
    void btnSeleccionar_pulsado(ActionEvent event) {
        Alumno alumno = (Alumno) this.cmbAlumnos.getSelectionModel().getSelectedItem();
        if (alumno!=null){
            this.txtNombre.setText(alumno.nombre());
            this.txtNota.setText(alumno.nota()+"");
        }else {
            Alert alerta = new Alert(Alert.AlertType.ERROR,"Ningún alumno seleccionado");
            alerta.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AlumnoLista lista = new AlumnoLista();
        this.cmbAlumnos.getItems().addAll(lista.consultarAlumnos());
    }

}


