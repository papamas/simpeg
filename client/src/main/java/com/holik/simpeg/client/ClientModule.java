package com.holik.simpeg.client;

import com.holik.simpeg.client.place.NameTokens;
import com.holik.simpeg.client.application.ApplicationModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.holik.simpeg.client.security.CurrentUser;
import com.holik.simpeg.client.services.ServiceModule;

public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        
        bind(CurrentUser.class).asEagerSingleton();
        bindConstant().annotatedWith(RestApplicationPath.class).
                to("http://127.0.0.1:8080/api");

        install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.LOGIN)
                .build());
            
        install(new ServiceModule());
        install(new ApplicationModule());
        
    }
}
