package unam.diplomado.pixup.disco.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscoRequestDTO {

    private String titulo;
    private Float precio;
    private Integer existencia;
    private Float descuento;
    private Date fechaLanzamiento;
    private String imagen;
    private Disquera disquera;
    private Artista artista;
    private GeneroMusical generoMusical;



}
