package unam.diplomado.pixup.disco.domain;

public class DiscoBadRequestException extends RuntimeException {

    public DiscoBadRequestException() {
        super("El objeto no cumple con el formato esperado");
    }

}
