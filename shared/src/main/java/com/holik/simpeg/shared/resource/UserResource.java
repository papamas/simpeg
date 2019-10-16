/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holik.simpeg.shared.resource;

import com.holik.simpeg.shared.model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author papamas
 */
@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public interface UserResource {
 
    @POST
    @Path("login")        
    Boolean isCurrentUserLoggedIn();
    
    @GET
    User  getCurrentUser();
}
