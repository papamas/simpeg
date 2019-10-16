package com.holik.simpeg.server;

//import com.github.aceroni75.gwtboot.shared.resource.ResourcePackage;
import com.holik.simpeg.shared.resource.ResourcePackage;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages(ResourcePackage.class.getPackage().getName());
    }
}
