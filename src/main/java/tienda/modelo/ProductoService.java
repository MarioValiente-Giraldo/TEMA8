package tienda.modelo;

import java.util.List;

public class ProductoService {
    private ProductoRepository repository;
    public ProductoService(){
        this.repository = new ProductoRepository();
    }
    public List<Producto> consultarPorductos(){
        return this.repository.consultarProductos();
    }
    public void tasar(Producto p){
        p.setTasar(true);
    }
    public void noTasar(Producto p){
        p.setTasar(false);
    }
    public void añadirUnidad(Producto p){
        p.setUnidades(p.getUnidades()+1);
    }
}
