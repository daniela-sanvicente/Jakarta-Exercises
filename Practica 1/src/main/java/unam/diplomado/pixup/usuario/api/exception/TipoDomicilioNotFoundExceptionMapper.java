package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import unam.diplomado.pixup.usuario.domain.TipoDomicilioNotFoundException;

public class TipoDomicilioNotFoundExceptionMapper
        implements ExceptionMapper<TipoDomicilioNotFoundException> {

    @Override
    public Response toResponse(TipoDomicilioNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                Response.Status.PRECONDITION_REQUIRED.getStatusCode(),
                "DATA_INCONSISTENCY",
                e.getMessage());
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(errorResponse)
                .build();
    }

}
