package BlocNotas.bloc.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardadorHtml extends GuardadorTxt{
    public GuardadorHtml(Documento d, String r) {
        super(d, r);
    }
    @Override
    public void guardar() throws IOException {
        File file = new File(this.ruta);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("<!DOCTYPE html>\n");
        bufferedWriter.write("<html lang=\"es\">\n");
        bufferedWriter.write("<head>\n");
        bufferedWriter.write("    <meta charset=\"UTF-8\">\n");
        bufferedWriter.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        bufferedWriter.write("    <title>Título</title>\n");
        bufferedWriter.write("</head>\n");
        bufferedWriter.write("<body>\n");
        bufferedWriter.write(this.documento.texto());
        bufferedWriter.write("</body>\n");
        bufferedWriter.write("</html>\n");

        bufferedWriter.close();
    }
}
