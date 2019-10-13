package com.holik.simpeg.client;

import com.holik.simpeg.client.place.NameTokens;
import com.holik.simpeg.client.application.ApplicationModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new RestDispatchAsyncModule.Builder().build());
        bindConstant().annotatedWith(RestApplicationPath.class).
                to("http://127.0.0.1:8080");

        install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.LOGIN)
                .build());

        install(new ApplicationModule());
    }
}
