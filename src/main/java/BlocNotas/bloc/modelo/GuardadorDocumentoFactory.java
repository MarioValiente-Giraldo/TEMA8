package BlocNotas.bloc.modelo;

public class GuardadorDocumentoFactory {
    public static GuardadorDocumento getGuardador(String extension,Documento d,String ruta){
       return switch (extension){
            case "txt" -> new GuardadorTxt(d,ruta);
            case "png" -> new GuardadorPng(d,ruta);
            case "html" -> new GuardadorHtml(d,ruta);
            default -> throw new IllegalArgumentException("Formato incompatible");
        };
    }
}
