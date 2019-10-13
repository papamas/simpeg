package com.holik.simpeg.server.controller;

import com.holik.simpeg.server.service.UserService;
import static com.holik.simpeg.shared.ResourcePaths.User.LOGIN;
import static com.holik.simpeg.shared.ResourcePaths.User.ROOT;
import com.holik.simpeg.shared.model.User;
import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.nuvola.myproject.server.service.UserService;
//import com.nuvola.myproject.shared.model.User;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

//import static com.nuvola.myproject.shared.ResourcePaths.User.LOGIN;
//import static com.nuvola.myproject.shared.ResourcePaths.User.ROOT;

@RestController
@RequestMapping(value = ROOT,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = LOGIN, method = GET)
    @PermitAll
    ResponseEntity<Boolean> isCurrentUserLoggedIn() {
        return new ResponseEntity<>(userService.isCurrentUserLoggedIn(), OK);
    }

    @RequestMapping(method = GET)
    ResponseEntity<User> getCurrentUser() {
        return ok(userService.getCurrentUser());
    }
}
