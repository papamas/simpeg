package com.holik.simpeg.shared.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/hello")
@Consumes("application/json")
@Produces("application/json")
public interface HelloResource {

    @GET
    String hello();
}
