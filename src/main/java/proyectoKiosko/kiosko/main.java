package proyectoKiosko.kiosko;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("frmVenta.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Kiosko");
            primaryStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
