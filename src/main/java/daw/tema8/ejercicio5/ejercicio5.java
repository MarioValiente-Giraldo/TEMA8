package daw.tema8.ejercicio5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ejercicio5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxm = new FXMLLoader(ClassLoader.getSystemResource("frmEjercicio5MVC.fxml"));
        try {
            Scene scene = new Scene(fxm.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ejercicio 5");
            primaryStage.show();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
