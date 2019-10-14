package com.holik.simpeg.client.login;

import com.google.gwt.core.client.GWT;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialTextBox;

public class LoginView extends 
        ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    MaterialTextBox login;
    @UiField
    MaterialTextBox password;

    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("submit")
    void onSubmitClicked(ClickEvent event) {
        GWT.log("User submit Login.", null);
        //Window.alert("hello" + login.getText() +"menekan tombol pada  button");
        getUiHandlers().login(login.getText(), password.getText());
    }
}
