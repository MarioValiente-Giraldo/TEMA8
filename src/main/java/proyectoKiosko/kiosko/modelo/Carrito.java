package proyectoKiosko.kiosko.modelo;

import java.util.ArrayList;
import java.util.List;
public class Carrito {
    private List<Producto> productos;
    public Carrito(){
        this.productos = new ArrayList<>();
    }
    public void añadir(Producto p){
        this.productos.add(p);
    }
    public void retirar(Producto p){
        this.productos.remove(p);
    }
    public int getNumeroProductos(){
        return this.productos.size();
    }
    public double getPrecio(){
        double precioTotal=0;
        for (Producto x : this.productos){
            precioTotal+=x.precio();
        }
        return precioTotal;
    }
    public List<Producto> getProductos(){
        return this.productos;
    }

}
