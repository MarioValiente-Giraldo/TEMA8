package BlocNotas.bloc.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class CargadorDocumento {
    public static Documento cargar(String ruta) throws IOException{
        String texto ="";
        FileReader fileReader = new FileReader(ruta);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        texto = bufferedReader.lines().collect(Collectors.joining("\n"));
        return new Documento(texto);
    }
}
