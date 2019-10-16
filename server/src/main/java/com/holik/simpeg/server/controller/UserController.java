package com.holik.simpeg.server.controller;

import com.holik.simpeg.server.service.UserService;
import com.holik.simpeg.shared.model.User;
import com.holik.simpeg.shared.resource.UserResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8888",
        allowedHeaders = "x-gwt-module-base",
        maxAge = 3600)
@RequestMapping(value = "/api/user",
        produces = MediaType.APPLICATION_JSON_VALUE)
*/

@Controller
public class UserController  implements UserResource{
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public Boolean isCurrentUserLoggedIn() {
        return userService.isCurrentUserLoggedIn();
    }   
    
    @Override
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
