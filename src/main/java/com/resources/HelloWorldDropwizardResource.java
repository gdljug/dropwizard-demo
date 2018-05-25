package com.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.core.entity.Person;
import com.core.service.HelloPersonService;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/api/")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class HelloWorldDropwizardResource {

    @Inject
    private HelloPersonService service;

    @GET
    @Path("hello/{name}")
    public String greeting(@PathParam("name") String name){
        return name + " welcome to my rest service";
    }

    @GET
    @Path("person/{id}")
    @UnitOfWork
    public Response getPerson(@PathParam("id") Long id){
        return Response.status(200).entity(service.getPerson(id)).build();
    }

    @GET
    @Path("person")
    @UnitOfWork
    public Response getPeople(){
        return Response.status(200).entity(service.getPeople()).build();
    }

    @DELETE
    @Path("person/{id}")
    @UnitOfWork
    public Response deletePerson(@PathParam("id") Long id){
        service.deletePerson(id);
        return Response.status(204).build();
    }

    @POST
    @Path("person")
    @UnitOfWork
    public Response savePerson(Person p){
        return Response.status(201).entity(service.savePerson(p)).build();
    }


}
