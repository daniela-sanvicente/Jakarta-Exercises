package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Disco;

import java.util.Optional;

public interface DiscoRepository {
    Disco save(Disco disco);
    Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista);
}
