package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.colonia.domain.Municipio;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @NotBlank(message = "Primer Apellido es requerido")
    private String primerApellido;

    @NotBlank(message = "Segundo Apellido es requerido")
    private String segundoApellido;

    @NotBlank(message = "Password es requerido")
    private String password;

    @NotBlank(message = "Email es requerido")
    private String email;

    @NotBlank(message = "RFC es requerido")
    private String rfc;
}
