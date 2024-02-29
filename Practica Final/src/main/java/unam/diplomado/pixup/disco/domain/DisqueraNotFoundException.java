package unam.diplomado.pixup.disco.domain;

public class DisqueraNotFoundException extends RuntimeException {
    public DisqueraNotFoundException(Integer id){
        super("No se encontro la disquera con id"+id);
    }

}
