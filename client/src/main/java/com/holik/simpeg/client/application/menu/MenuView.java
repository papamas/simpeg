package com.holik.simpeg.client.application.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class MenuView extends ViewWithUiHandlers<MenuHandlers> implements MenuPresenter.MyView {

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

   
    @UiHandler("home")
    public void homeClick(ClickEvent e) {
        getUiHandlers().onHome();
    }

    @UiHandler("profile")
    public void profileClick(ClickEvent e) {
        getUiHandlers().onProfile();
    }
    
    @UiHandler("tasks")
    public void tasksClick(ClickEvent e) {
        getUiHandlers().onTasks();
    }
    
    interface Binder extends UiBinder<Widget, MenuView> {
    }
}
