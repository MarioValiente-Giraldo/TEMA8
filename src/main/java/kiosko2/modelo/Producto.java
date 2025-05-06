package kiosko2.modelo;


import javafx.scene.image.Image;

import java.io.InputStream;

public record Producto(String nombre, double precio, String foto) {
    public Image imagen(){
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(this.foto);
        return new Image(inputStream);
    }

    @Override
    public String toString() {
        return this.nombre+" ("+this.precio+"€"+")";
    }
}
