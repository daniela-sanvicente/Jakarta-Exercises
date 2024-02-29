package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Disco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título es requerido")
    private String titulo;

    //@Pattern(regexp = "^(\\d{6})$",
           // message = "Formato no válido para precio")
    private float precio;

    private int existencia;

    @Pattern(regexp = "^(\\d{2})$",
            message = "Formato no válido para descuento")
    private float descuento;

    @NotBlank(message = "Fecha de lanzamiento es requerido")
    private Date fechaLanzamiento;

    @NotBlank(message = "Nombre es requerido")
    private String imagen;

    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name = "id_disquera", nullable = false)
    @NotNull(message = "La disquera debe estar asociada a un Disco")
    private Disquera disquera;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "id_artista", nullable = false)
    @NotNull(message = "El artista debe estar asociada a un Disco")
    private Artista artista;

    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    @NotNull(message = "El genero musical debe estar asociada a un Disco")
    private GeneroMusical generoMusical;
}