package com.holik.simpeg.client.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.gwtplatform.dispatch.rest.shared.RestAction;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

import static com.holik.simpeg.client.place.NameTokens.LOGIN;
import static com.holik.simpeg.shared.Parameters.PASSWORD;
import static com.holik.simpeg.shared.Parameters.USERNAME;
import static com.holik.simpeg.shared.ResourcePaths.User.ROOT;
import com.holik.simpeg.shared.model.User;

@Path(ROOT)
public interface UserService {
    @POST
    @Path(LOGIN)
    @Consumes(APPLICATION_FORM_URLENCODED)
    RestAction<Void> login(@FormParam(USERNAME) String username, @FormParam(PASSWORD) String password);

    @DELETE
    @Path(LOGIN)
    RestAction<Void> logout();

    @GET
    @Path(LOGIN)
    RestAction<Boolean> isCurrentUserLoggedIn();

    @GET
    RestAction<User> getCurrentUser();
}
