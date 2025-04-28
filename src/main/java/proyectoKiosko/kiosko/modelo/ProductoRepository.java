package proyectoKiosko.kiosko.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private List<Producto> productos;
    public ProductoRepository(){
        this.productos = new ArrayList<>(List.of(
            new Producto("Cerveza",2.5,"imagenes/cerveza.jpg"),
                new Producto("Chocolatina",1.8,"imagenes/chocolatina.jpg"),
                new Producto("ChupaChups",0.75,"imagenes/chupachups.jpg"),
                new Producto("Frutos Secos",1.5,"imagenes/frutosSecos.jpg"),
                new Producto("Palomitas",1.5,"imagenes/palomitas.jpg"),
                new Producto("Pipas",1.5,"imagenes/pipas.jpg"),
                new Producto("Refresco",2,"imagenes/refresco.jpg"),
                new Producto("Regaliz",0.2,"imagenes/regaliz.jpg")
        ));
    }
    public List<Producto> consultarProductos(){
        return this.productos;
    }
}
