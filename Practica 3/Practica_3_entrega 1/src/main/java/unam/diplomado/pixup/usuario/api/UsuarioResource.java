package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.usuario.api.dto.RegistroUsuarioDTO;
import unam.diplomado.pixup.usuario.api.dto.RegistroUsuarioMapper;
import unam.diplomado.pixup.usuario.api.dto.UsuarioResponseDTO;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.service.UsuarioService;

public class UsuarioResource implements UsuarioApi {

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private RegistroUsuarioMapper registroUsuarioMapper;

    @Override
    public Response registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        // Transformacion DTO - Entity
        Usuario usuario = registroUsuarioMapper.toUsuario(registroUsuarioDTO.getUsuario());
        Domicilio domicilio = registroUsuarioMapper.toDomicilio(registroUsuarioDTO.getDomicilio());

        // Invocacion servicio negocio
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, domicilio);

        // Transformacion Entity - DTO
        UsuarioResponseDTO usuarioResponseDTO = registroUsuarioMapper.toDto(usuarioCreado);
        return Response
                .status(Response.Status.CREATED)
                .entity(usuarioResponseDTO)
                .build();
    }

}
