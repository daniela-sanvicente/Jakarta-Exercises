package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Disco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título es requerido")
    private String titulo;

    @NotNull(message = "Precio es requerido")
    private Float precio;

    @NotNull(message = "Existencia es requerido")
    private Integer existencia;

    @NotNull(message = "Descuento es requerido")
    private Float descuento;

    @Column(name = "fecha_lanzamiento")
    @NotNull(message = "Fecha de lanzamiento es requerido")
    private Date fechaLanzamiento;

    @NotBlank(message = "Imagen es requerido")
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


    public Disco(Integer id, String titulo, Float precio, Integer existencia, Float descuento, Date fechaLanzamiento, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
    }

}