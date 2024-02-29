package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.DiscoMapper;
import unam.diplomado.pixup.disco.api.dto.DiscoRequestDTO;
import unam.diplomado.pixup.disco.api.dto.DiscoResponseDTO;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.service.DiscoService;
import unam.diplomado.pixup.usuario.api.dto.UsuarioResponseDTO;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;
    @Inject
    private DiscoMapper discoMapper;



    @Override
    public Response altaDisco(DiscoRequestDTO discoRequestDTO) {
        try {
            Disco disco = discoMapper.toDisco(discoRequestDTO);
            Disco discoCreado= discoService.registrarDisco(disco);
            DiscoResponseDTO discoResponseDTO = discoMapper.toDto(discoCreado);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(discoResponseDTO)
                    .build();
        }catch (Exception e) {
            if(e.getCause() instanceof DiscoAlreadyExistsException) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(e.getCause().getMessage())
                        .build();
            }
            if(e.getCause() instanceof DiscoBadRequestException) {

                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity(e.getCause().getMessage())
                        .build();
            }
            return Response
                    .status(Response.Status.PRECONDITION_REQUIRED)
                    .entity(e.getCause().getMessage())
                    .build();
        }


    }




}
