package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.colonia.domain.Municipio;
import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

@Singleton
public class JpaArtistaRepository implements ArtistaRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override //Optional es una abstraccion sobre un objeto que puede retornar nulo o no, su principal aplicacion es el metodo isPresent (verificar si ha retornado o no un nulo)
    public Optional<Artista> findById(Integer id) { // find (entidad, parametro)

        Artista artista = entityManager.find(Artista.class, id);
        return artista != null ? Optional.of(artista) : Optional.empty();

        /* Optional<Artista> artista = Optional.ofNullable(entityManager.find(Artista.class, id)); //guardamos en una variable del tipo artista, usamos el gerenciador de entidades para buscar la entidad artista
        return artista.isPresent() ? artista : Optional.empty();*/
    }


}
