package tienda.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private List<Producto> productos;
    ProductoRepository(){
        this.productos = new ArrayList<>(List.of(
                new Producto("KBD-2052","Teclado mecánico",100,5,true),
                new Producto("REF-44251","Tarrina de dvd",15,8,false),
                new Producto("RZ75700X","Procesador Ryzen 7 5700x",0,0,false)
        ));
    }
    public Optional<Producto> getProducto(String id){
        return this.productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst();
    }
    public List<Producto> consultarProductos(){
        return Collections.unmodifiableList(this.productos);
    }
}
