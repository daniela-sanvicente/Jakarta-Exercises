package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Data
@NoArgsConstructor
@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    @Column(name="num_exterior")
    private String numExterior;
    @Column(name="num_interior")
    private String numInterior;
    @ManyToOne(targetEntity=Colonia.class)
    @JoinColumn(name="id_colonia", nullable=false)
    private Colonia colonia;
    @ManyToOne(targetEntity=Usuario.class)
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
    @ManyToOne(targetEntity=TipoDomicilio.class)
    @JoinColumn(name="id_tipo_domicilio", nullable=false)
    private TipoDomicilio tipoDomicilio;

    public Domicilio(
            String calle, String numExterior, String numInterior,
            Integer idColonia, Integer idTipoDomicilio) {
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.colonia = new Colonia();
        this.colonia.setId(idColonia);
        this.tipoDomicilio = new TipoDomicilio();
        this.tipoDomicilio.setId(idTipoDomicilio);
    }

}
