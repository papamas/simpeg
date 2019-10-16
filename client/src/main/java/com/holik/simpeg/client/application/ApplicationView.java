package com.holik.simpeg.client.application;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialSideNavPush;

class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {

    @UiField
    MaterialSideNavPush menu;
    
    @UiField
    MaterialContainer container;

    @UiField
    MaterialButton btnAdd;
    
    @UiField
    MaterialNavBar appNav, searchNav;
     
    @UiField
    MaterialSearch search;
    
    @Inject
    ApplicationView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
        bindSlot(ApplicationPresenter.SLOT_MAIN, container);
        bindSlot(ApplicationPresenter.SLOT_MENU, menu);
        //bindSlot(ApplicationPresenter.SLOT_MAIN, main);
    }

    interface Binder extends UiBinder<Widget, ApplicationView> {
    }
}
