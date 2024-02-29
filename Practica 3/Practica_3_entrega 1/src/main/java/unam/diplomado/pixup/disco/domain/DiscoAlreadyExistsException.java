package unam.diplomado.pixup.disco.domain;

public class DiscoAlreadyExistsException extends RuntimeException {

    public DiscoAlreadyExistsException(String titulo, Integer idArtista) {
        super("Ya existe disco con titulo: " + titulo + " e id del artista: " + idArtista);
    }

}
