package tienda.modelo;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int unidades;
    private boolean tasable;
    public Producto(String id,String n,double p,int u,boolean t){
        this.id = id;
        this.nombre = n;
        this.precio = p;
        this.unidades = u;
        this.tasable = t;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public boolean isTasable() {
        return tasable;
    }
    void  setUnidades(int u){
        this.unidades=u;
    }
    void setTasar(boolean b){
        this.tasable = b;
    }
}
