
package com.holik.simpeg.client.application.profile;

import com.holik.simpeg.client.application.ApplicationPresenter;
import com.holik.simpeg.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class ProfilePresenter extends 
        Presenter<ProfilePresenter.MyView, ProfilePresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.PROFILE)
    interface MyProxy extends ProxyPlace<ProfilePresenter> {
    }

    @Inject
    ProfilePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }
}
