package com.firetruckbowl.apisample.resource;

import com.firetruckbowl.apisample.model.Starship;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("starship")
public class StarshipResource {

  @GET
  @Path("hello")
  @Produces(MediaType.TEXT_PLAIN)
  public Response hello() {
    return Response.status(Response.Status.OK).entity("Hello world").build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getStarship(@PathParam("id") String id) {
    Starship pegasus = new Starship();
    pegasus.setId(id);
    pegasus.setName("Pegasus");
    pegasus.setModel("Mercury");

    return Response.status(Response.Status.OK).entity(pegasus).build();
  }
}
