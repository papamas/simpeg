package com.holik.simpeg.client.services;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
//import javax.inject.Singleton;

public class ServiceModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new RestDispatchAsyncModule.Builder().build());
    }

    
    
    //@RestApplicationPath
    @Singleton
    @Provides
    String getApplicationPath() {
        String baseUrl = GWT.getHostPageBaseURL();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        return baseUrl;
    }
}
