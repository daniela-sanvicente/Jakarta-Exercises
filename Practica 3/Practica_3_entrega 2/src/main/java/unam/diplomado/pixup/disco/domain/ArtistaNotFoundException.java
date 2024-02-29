package unam.diplomado.pixup.disco.domain;

public class ArtistaNotFoundException extends RuntimeException {
    public ArtistaNotFoundException(Integer id){
        super("No se encontro el artista con id"+id);
    }

}
