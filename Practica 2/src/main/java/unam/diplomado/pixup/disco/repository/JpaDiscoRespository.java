package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.disco.domain.Disco;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRespository implements DiscoRepository {
    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);//guarda los datos en el banco de datos para que los datos persistan aparte de estar en java
        return disco;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo,Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery( // en jpa ":" se usa para subtituir por lo que quiero, sino agregaría directamente la cadena "titulo" o "idArtista"
                "SELECT d FROM Disco d WHERE d.titulo = :titulo AND d.id_artista = :idArtista", Disco.class);
        query.setParameter("titulo", titulo); //subtituye :titulo
        query.setParameter("idArtista", idArtista); //subtituye :idArtista
        List<Disco> discos = query.getResultList();
        return !discos.isEmpty() ? Optional.of(discos.get(0)) : Optional.empty();
    }

}
