package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

import java.util.Date;
import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService {
    @Inject
    private ArtistaRepository artistaRepository;

    @Inject
    private DiscoRepository discoRepository;

    @Inject
    private DisqueraRepository disqueraRepository;

    @Inject
    private GeneroMusicalRepository generoMusicalRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Disco registrarDisco(Disco disco) {
        //Revisar que exista el artista, genero y disquera
        //Que el disco no este previamente registrado
        //Si no cumple lanzar una excepcion

        if (
            !(disco.getTitulo() instanceof String ) ||
            !(disco.getPrecio() instanceof Float ) ||
            !(disco.getExistencia() instanceof Integer)||
            !(disco.getDescuento() instanceof Float) ||
            !(disco.getFechaLanzamiento() instanceof Date) ||
            !(disco.getImagen() instanceof String)
        ) {
            throw new DiscoBadRequestException();
        }

        // validacion disco duplicado
        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());

        if (discoExistente.isPresent()) {
            throw new DiscoAlreadyExistsException(disco.getTitulo(), disco.getArtista().getId());
        }

        // validacion disquera
        Optional<Disquera> disquera = disqueraRepository.findById(disco.getDisquera().getId());

        if (disquera.isEmpty()) {
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }

        disco.setDisquera(disquera.get());

        // validacion artista
        Optional<Artista> artista = artistaRepository.findById(disco.getArtista().getId());

        if (artista.isEmpty()) {
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }

        disco.setArtista(artista.get());

        // validacion genero musical
        Optional<GeneroMusical> generoMusical = generoMusicalRepository.findById(disco.getGeneroMusical().getId());

        if (generoMusical.isEmpty()) {
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }

        disco.setGeneroMusical(generoMusical.get());

        // persistencia/guardado entidades
        discoRepository.save(disco);

        return disco;
    }
}
