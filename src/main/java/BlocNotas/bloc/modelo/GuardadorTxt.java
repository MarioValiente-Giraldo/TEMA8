package BlocNotas.bloc.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GuardadorTxt extends GuardadorDocumento{
    public GuardadorTxt(Documento d,String r){
        super(d,r);
    }
    @Override
    public void guardar() throws IOException {
       File file = new File(this.ruta);
       FileWriter fileWriter = new FileWriter(file);
       BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
       bufferedWriter.write(this.documento.texto());
       bufferedWriter.close();
    }
}
