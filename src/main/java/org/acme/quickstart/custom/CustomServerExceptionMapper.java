package org.acme.quickstart.custom;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomServerExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException> {

    @Override
    public Response toResponse(UnrecognizedPropertyException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("MyServerExceptionMapper: " + e.getMessage())
                .build();
    }
}