package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DiscoNotFoundException;

@Provider
public class DiscoNotFoundExceptionMapper
        implements ExceptionMapper<DiscoNotFoundException> {

    @Override
    public Response toResponse(DiscoNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}
