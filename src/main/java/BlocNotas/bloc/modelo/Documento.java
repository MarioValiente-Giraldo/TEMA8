package BlocNotas.bloc.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Documento(String texto) {
    public List<String>getRengolnes(){
        List<String> renglones = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<this.texto.length();i++){
            char caracter = texto.charAt(i);
            if (caracter == '\n'){
                renglones.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }else {
                stringBuilder.append(caracter);
                if (stringBuilder.length() == 80){
                    renglones.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }
        }
        return Collections.unmodifiableList(renglones);
    }
}
