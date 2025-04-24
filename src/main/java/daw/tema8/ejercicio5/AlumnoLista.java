package daw.tema8.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class AlumnoLista {
    private List<Alumno> alumnos;
    public AlumnoLista(){
        this.alumnos = new ArrayList<>(List.of(
                new Alumno("Mario",8),
                new Alumno("Carolina",4),
                new Alumno("Cazorla",9),
                new Alumno("Harry",6)
                ));
    }
    public List<Alumno> consultarAlumnos(){
        return this.alumnos;
    }
}
