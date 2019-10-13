package com.holik.simpeg.server.resource;

import com.holik.simpeg.shared.resource.HelloResource;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController implements HelloResource {

    @Override
    public String hello() {
        return "Hello world!";
    }
}
