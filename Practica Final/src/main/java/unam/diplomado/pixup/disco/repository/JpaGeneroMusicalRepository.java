package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Optional;

@Singleton
public class JpaGeneroMusicalRepository implements GeneroMusicalRepository{

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical generoMusical = entityManager.find(GeneroMusical.class, id);
        return generoMusical != null ? Optional.of(generoMusical) : Optional.empty();
    }
}
