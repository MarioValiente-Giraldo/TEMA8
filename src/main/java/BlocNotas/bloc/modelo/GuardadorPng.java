package BlocNotas.bloc.modelo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GuardadorPng extends GuardadorDocumento{
    public GuardadorPng(Documento d, String r){
        super(d,r);
    }
    @Override
    public void guardar() throws IOException {
        File file = new File(this.ruta);
        int y = 50;
        int max = this.documento.getRengolnes().stream()
                .mapToInt( x -> x.length() )
                .max()
                .orElse(0);
        int ancho = max * 20;
        int alto = this.documento.getRengolnes().size() * 20;
        BufferedImage bufferedImage = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        for (int i = 0; i<this.documento.getRengolnes().size();i++){
            graphics.drawString(this.documento.getRengolnes().get(i),30,y);
            y+=15;
        }
        graphics.dispose();
        ImageIO.write(bufferedImage,"png",file);
    }
}
