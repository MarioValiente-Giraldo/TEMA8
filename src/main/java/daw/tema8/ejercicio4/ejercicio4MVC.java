package daw.tema8.ejercicio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ejercicio4MVC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxm = new FXMLLoader(ClassLoader.getSystemResource("frmEjercicio4MVC.fxml"));
            Scene e = new Scene(fxm.load());
            primaryStage.setScene(e);
            primaryStage.setTitle("Ejercicio 4");
            primaryStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
