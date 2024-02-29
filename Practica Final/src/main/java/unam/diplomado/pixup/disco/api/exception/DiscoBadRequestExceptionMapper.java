package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.DiscoBadRequestException;

@Provider
public class DiscoBadRequestExceptionMapper
        implements ExceptionMapper<DiscoBadRequestException> {

    @Override
    public Response toResponse(DiscoBadRequestException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }

}