package com.firetruckbowl.apisample.resource;

import com.firetruckbowl.apisample.model.Starship;
import com.firetruckbowl.tgirest.annotation.ParamNote;
import com.firetruckbowl.tgirest.annotation.ResourceDoc;
import com.firetruckbowl.tgirest.annotation.ResourceMethod;
import com.firetruckbowl.tgirest.model.ResourceDocument;
import com.firetruckbowl.tgirest.processor.TGIRestDocumenter;
import com.firetruckbowl.tgirest.resource.Documented;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@ResourceDoc(description = "Provides a means to manage the starships in your fleet")
@Path("starship")
public class StarshipResource implements Documented {

  @GET
  @Path("hello")
  @Produces(MediaType.TEXT_PLAIN)
  public Response hello() {
    return Response.status(Response.Status.OK).entity("Hello world").build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @ResourceMethod(description = "Get a starship by its ID", status = Response.Status.OK)
  public Response getStarship(@PathParam("id") @ParamNote("The starship ID") String id) {
    Starship pegasus = new Starship();
    pegasus.setId(id);
    pegasus.setName("Pegasus");
    pegasus.setModel("Mercury");

    return Response.status(Response.Status.OK).entity(pegasus).build();
  }

  @Override
  public Response getDocumentation(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
    TGIRestDocumenter documenter = new TGIRestDocumenter();
    ResourceDocument doc = documenter.generateResourceDocument(uriInfo, this);
    return Response.status(Response.Status.OK).entity(doc).build();
  }
}
