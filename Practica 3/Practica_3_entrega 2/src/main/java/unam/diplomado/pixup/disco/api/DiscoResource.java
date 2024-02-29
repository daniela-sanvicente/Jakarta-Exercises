package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreadyExistsException;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.service.DiscoService;
import unam.diplomado.pixup.usuario.api.exception.ErrorResponse;
import unam.diplomado.pixup.usuario.domain.TipoDomicilioNotFoundException;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistsException;

import java.util.Collection;
import java.util.Date;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoRepository discoRepository;
    @Inject
    private DiscoService discoService;



    @Override

    public Response altaDisco(Disco disco) {
        try {
            Disco discoCreada = discoService.registrarDisco(disco);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(discoCreada)
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
