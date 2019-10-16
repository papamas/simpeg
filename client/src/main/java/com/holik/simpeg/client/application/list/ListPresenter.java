package com.holik.simpeg.client.application.list;

import com.holik.simpeg.client.application.ApplicationPresenter;
import com.holik.simpeg.shared.entity.Task;
//import com.holik.simpeg.server.resource.TaskController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.holik.simpeg.client.place.NameTokens;


import java.util.Collections;

import static com.holik.simpeg.client.place.NameTokens.*;
import static com.holik.simpeg.client.place.ParameterTokens.ID;
import static com.holik.simpeg.client.util.Places.using;
import static com.holik.simpeg.client.util.Rest.popupAndLog;
import static com.holik.simpeg.client.util.Rest.using;
import com.holik.simpeg.shared.resource.TaskResource;

public class ListPresenter extends Presenter<ListPresenter.MyView, ListPresenter.MyProxy> implements ListHandlers {

    private final PlaceManager placeManager;
    private final ResourceDelegate<TaskResource> taskDelegate;

    @ProxyStandard
    @NameToken(NameTokens.LIST)
    interface MyProxy extends ProxyPlace<ListPresenter> {
    }
    
    @Inject
    ListPresenter(EventBus eventBus,
            MyView view, 
            MyProxy proxy, 
            PlaceManager placeManager,
            ResourceDelegate<TaskResource> taskDelegate) {
        super(eventBus, view,
                proxy, ApplicationPresenter.SLOT_MAIN);
        this.placeManager = placeManager;
        this.taskDelegate = taskDelegate;
        view.setUiHandlers(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        getView().setTasks(Collections.emptyList());
        using(taskDelegate)
                .call(TaskResource::getAllTasks)
                .onSuccess(getView()::setTasks)
                .onFailure(popupAndLog("Cannot retrieve task list"))
                .apply();
    }

    @Override
    public void viewTask(Long id) {
        using(placeManager).with(ID, id).reveal(TASK);
    }

    @Override
    public void onAdd() {
        using(placeManager).reveal(ADD);
    }

    @Override
    public void onRefresh() {
        placeManager.revealCurrentPlace();
    }

    interface MyView extends View, HasUiHandlers<ListHandlers> {
        void setTasks(Iterable<Task> tasks);
    }

    
}