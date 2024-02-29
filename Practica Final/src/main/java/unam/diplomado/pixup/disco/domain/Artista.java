package unam.diplomado.pixup.disco.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                '}';
    }
}