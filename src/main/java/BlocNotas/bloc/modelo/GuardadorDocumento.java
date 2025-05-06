package BlocNotas.bloc.modelo;

import java.io.IOException;

public abstract class GuardadorDocumento {
    protected Documento documento;
    protected String ruta;
    public GuardadorDocumento(Documento d,String r){
        this.documento = d;
        this.ruta = r;
    }
    public abstract void guardar() throws IOException;
}
