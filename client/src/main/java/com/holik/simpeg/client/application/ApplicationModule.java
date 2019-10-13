package com.holik.simpeg.client.application;


import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.holik.simpeg.client.application.edit.EditModule;
import com.holik.simpeg.client.application.home.HomeModule;
import com.holik.simpeg.client.application.list.ListModule;
import com.holik.simpeg.client.application.menu.MenuModule;
import com.holik.simpeg.client.application.profile.ProfileModule;
import com.holik.simpeg.client.application.task.TaskModule;
import com.holik.simpeg.client.login.LoginModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new LoginModule());
        install(new MenuModule());
        install(new HomeModule());
        install(new ProfileModule());
        install(new ListModule());
        install(new TaskModule());
        install(new EditModule());

        bindPresenter(ApplicationPresenter.class,
                ApplicationPresenter.MyView.class,
                ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}