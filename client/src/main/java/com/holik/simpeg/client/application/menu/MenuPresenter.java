package com.holik.simpeg.client.application.menu;

import com.holik.simpeg.client.util.Places;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import static com.holik.simpeg.client.place.NameTokens.HOME;
import static com.holik.simpeg.client.place.NameTokens.LIST;
import static com.holik.simpeg.client.place.NameTokens.PROFILE;
import static com.holik.simpeg.client.place.NameTokens.TASK;

public class MenuPresenter 
        extends PresenterWidget<MenuPresenter.MyView> 
        implements MenuHandlers {

    private final PlaceManager placeManager;

    @Inject
    MenuPresenter(EventBus eventBus, MyView view, PlaceManager placeManager) {
        super(eventBus, view);
        this.placeManager = placeManager;
        view.setUiHandlers(this);
    }

    @Override
    public void onHome() {
        Places.using(placeManager).reveal(HOME);
    }

    @Override
    public void onProfile() {
        Places.using(placeManager).reveal(PROFILE);
    }
    
    @Override
    public void onTasks() {
        Places.using(placeManager).reveal(LIST);
    }

    interface MyView extends View, HasUiHandlers<MenuHandlers> {
    }
}
