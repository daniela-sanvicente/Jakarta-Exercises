package unam.diplomado.pixup.disco.domain;

public class GeneroMusicalNotFoundException extends RuntimeException {
    public GeneroMusicalNotFoundException(Integer id){
        super("No se encontro el genero musical con id"+id);
    }

}
