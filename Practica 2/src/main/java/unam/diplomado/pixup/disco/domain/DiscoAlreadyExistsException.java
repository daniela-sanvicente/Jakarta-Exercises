package unam.diplomado.pixup.disco.domain;

public class DiscoAlreadyExistsException extends RuntimeException {

    public DiscoAlreadyExistsException(String titulo,  Integer idArtista) {
        super("Ya existe el disco con titulo: " + titulo + " y artista de Id: " + idArtista);
    }

}
