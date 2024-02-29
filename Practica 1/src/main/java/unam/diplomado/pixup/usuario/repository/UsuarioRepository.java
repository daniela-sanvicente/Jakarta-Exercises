package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByEmail(String email);
    Usuario save(Usuario usuario);

}
