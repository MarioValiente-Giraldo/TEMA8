package daw.tema8.ejercicio5;

public record Alumno(String nombre,int nota) {
    @Override
    public String toString() {
        return this.nombre;
    }
}
