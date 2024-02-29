package unam.diplomado.pixup.disco.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.GeneroMusical;
import unam.diplomado.pixup.disco.domain.Disquera;

@Singleton
public class DiscoMapper {

    public DiscoResponseDTO toDto(Disco disco) {
        return new DiscoResponseDTO(
                disco.getId(), disco.getTitulo(), disco.getPrecio(),
                disco.getExistencia(), disco.getDescuento(),
                disco.getFechaLanzamiento(), disco.getImagen(),
                disco.getDisquera(), disco.getArtista(), disco.getGeneroMusical());

    }

    public Disco toDisco(DiscoRequestDTO discoRequestDTO) {
        return new Disco(null, discoRequestDTO.getTitulo(), discoRequestDTO.getPrecio(),
                discoRequestDTO.getExistencia(), discoRequestDTO.getDescuento(),
                discoRequestDTO.getFechaLanzamiento(), discoRequestDTO.getImagen(),
                discoRequestDTO.getDisquera(), discoRequestDTO.getArtista(), discoRequestDTO.getGeneroMusical());
    }

    public Artista toArtista(ArtistaDTO artistaDTO) {
        return new Artista(artistaDTO.getId(), artistaDTO.getNombre());
    }

    public Disquera toDisquera(DisqueraDTO disqueraDTO) {
        return new Disquera(disqueraDTO.getId(), disqueraDTO.getNombre());
    }

    public GeneroMusical toGeneroMusical(GeneroMusicalDTO generoMusicalDTO) {
        return new GeneroMusical(generoMusicalDTO.getId(), generoMusicalDTO.getDescripcion());
    }




}