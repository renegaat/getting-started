package org.acme.quickstart;

import org.acme.quickstart.model.Developer;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

// example rest endpoints
@Path("/hello")
public class GreetingResource {

    public enum Order {
        desc,asc
    }

    //get endpoint, returns uri path, query param and header param
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo,
                        @QueryParam("order") Order order,
                        @NotBlank @HeaderParam("authorization") String auth) {

        return String.format("hello.return %s %s %s", uriInfo.getPath(), order, auth);
    }

    //post endpoint
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {

        return Response.created(
                UriBuilder.fromResource(GreetingResource.class)
                        .path(String.valueOf(developer.getName()))
                        .build()
        ).entity(developer).build();
    }

    //put endpoint
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        System.out.println(message);
        return "update";
    }

    //delete endpoint
    @DELETE
    public void delete() {
        System.out.println("delete");
    }

}
