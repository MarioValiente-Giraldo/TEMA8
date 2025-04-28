package proyectoKiosko.kiosko.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import proyectoKiosko.kiosko.modelo.Producto;

public class CeldaImagen extends TableCell<Producto, Image> {

    @Override
    protected void updateItem(Image image, boolean b){
        super.updateItem(image,b);
        this.setAlignment(Pos.CENTER);
        if(b){
            this.setGraphic(null);
        }else {
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            this.setGraphic(imageView);
        }

    }
}
