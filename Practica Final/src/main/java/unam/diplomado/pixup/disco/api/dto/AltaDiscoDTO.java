package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AltaDiscoDTO {
    @NotNull(message="Disco es requerido para realizar el alta")
    @Valid
    private DiscoRequestDTO discoRequestDTO;
    @NotNull(message="Artista es requerido para realizar el alta")
    @Valid
    private ArtistaDTO artistaDTO;
    @NotNull(message="Disquera es requerido para realizar el alta")
    @Valid
    private  DisqueraDTO disqueraDTO;
    @NotNull(message="Genero Musical es requerido para realizar el alta")
    @Valid
    private GeneroMusicalDTO generoMusicalDTO;
}
