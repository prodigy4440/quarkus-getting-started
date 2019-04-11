package org.acme.quickstart;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @Path("{id}")
    @GET
    public Response getPerson(@PathParam("id")Long id){
        return Response.ok(personService.get(id)).build();
    }

    @GET
    public Response getAllPerson(){
        return Response.ok(personService.getAll()).build();
    }

    @Path("create")
    @POST
    public Response create(Person person){
        return Response.ok(personService.persist(person)).build();
    }
}
