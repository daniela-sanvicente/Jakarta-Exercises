package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.ArtistaNotFoundException;

@Provider
public class ArtistaNotFoundExceptionMapper
        implements ExceptionMapper<ArtistaNotFoundException> {

    @Override
    public Response toResponse(ArtistaNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(e.getMessage())
                .build();
    }

}
