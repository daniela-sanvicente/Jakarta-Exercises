package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.GeneroMusicalNotFoundException;

@Provider
public class GeneroMusicalNotFoundExceptionMapper
        implements ExceptionMapper<GeneroMusicalNotFoundException> {

    @Override
    public Response toResponse(GeneroMusicalNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(e.getMessage())
                .build();
    }

}
