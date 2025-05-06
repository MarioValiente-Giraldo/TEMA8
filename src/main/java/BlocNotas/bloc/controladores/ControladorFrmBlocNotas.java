package BlocNotas.bloc.controladores;
import BlocNotas.bloc.modelo.CargadorDocumento;
import BlocNotas.bloc.modelo.Documento;
import BlocNotas.bloc.modelo.GuardadorDocumento;
import BlocNotas.bloc.modelo.GuardadorDocumentoFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorFrmBlocNotas {

    @FXML
    private MenuItem btn_Salir;

    @FXML
    private MenuItem btn_abrir;

    @FXML
    private MenuItem btn_guardar;

    @FXML
    private Label lblEstado;

    @FXML
    private MenuBar mn_menu;

    @FXML
    private TextArea txtTexto;

    @FXML
    void btn_SalirPulsado(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btn_abrirPulsado(ActionEvent event) {
        Stage stage =(Stage) txtTexto.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file!=null){
            try {
                Documento  documento= CargadorDocumento.cargar(file.getAbsolutePath());
                this.txtTexto.setText(documento.texto());
            }catch (IOException e){
                throw  new RuntimeException(e);
            }
            this.lblEstado.setText("Archivo seleccionado: "+file.getAbsolutePath());
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"No se ha seleccionado ningun archivo");
            alert.show();
        }
    }

    @FXML
    void btn_guardarPulsado(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        List<FileChooser.ExtensionFilter> extensionFilters = fileChooser.getExtensionFilters();

        List<FileChooser.ExtensionFilter> lista = new ArrayList<>(List.of(
                new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Archivos HTML (*.html)", "*.html"),
                new FileChooser.ExtensionFilter("Imagen PNG (*.png)", "*.png")
        ));
        fileChooser.getExtensionFilters().addAll(lista);
        Stage stage = (Stage)this.lblEstado.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file !=null){
            String seleccionExtension = fileChooser.getSelectedExtensionFilter().getExtensions().get(0);
            String formato = seleccionExtension.replace("*.", "");
            GuardadorDocumento guardadorDocumento = GuardadorDocumentoFactory.getGuardador(formato,new Documento(this.txtTexto.getText()),file.getAbsolutePath());
            try {
                guardadorDocumento.guardar();
                this.lblEstado.setText("El documento se ha guardado con éxito");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Ha ocurrido un error a la hora de guardar el mensaje");
            alert.show();
        }

    }

}

