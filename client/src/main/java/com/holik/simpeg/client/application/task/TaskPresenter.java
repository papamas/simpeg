package com.holik.simpeg.client.application.task;

import com.holik.simpeg.shared.entity.Task;
import com.holik.simpeg.shared.resource.TaskResource;
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

import static com.holik.simpeg.client.application.ApplicationPresenter.SLOT_MAIN;
import static com.holik.simpeg.client.place.NameTokens.*;
import static com.holik.simpeg.client.place.ParameterTokens.ID;
import static com.holik.simpeg.client.util.Places.from;
import static com.holik.simpeg.client.util.Places.using;
import static com.holik.simpeg.client.util.Rest.popupAndLog;
import static com.holik.simpeg.client.util.Rest.using;

public class TaskPresenter extends Presenter<TaskPresenter.MyView, TaskPresenter.MyProxy> implements TaskHandlers {

    private final PlaceManager placeManager;
    private final ResourceDelegate<TaskResource> taskDelegate;

    @Inject
    TaskPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager,
                  ResourceDelegate<TaskResource> taskDelegate) {
        super(eventBus, view, proxy, SLOT_MAIN);
        this.placeManager = placeManager;
        this.taskDelegate = taskDelegate;
        view.setUiHandlers(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        getView().clearTask();
        from(request).getLong(ID).ifPresent(id -> {
                using(taskDelegate)
                        .call(r -> r.getTask(id))
                        .onSuccess(getView()::setTask)
                        .onFailure(popupAndLog("Cannot retrieve task " + id))
                        .apply();
            }
        );
    }

    @Override
    public void onEdit(Long id) {
        using(placeManager).with(ID, id).reveal(EDIT);
    }

    @Override
    public void onDelete(Long id) {
        using(taskDelegate)
                .call(r -> r.deleteTask(id))
                .onSuccess(v -> using(placeManager).reveal(LIST))
                .onFailure(popupAndLog("Cannot delete task " + id))
                .apply();
    }

    @Override
    public void onBack() {
        using(placeManager).reveal(LIST);
    }

    interface MyView extends View, HasUiHandlers<TaskHandlers> {
        void setTask(Task task);

        void clearTask();
    }

    @ProxyStandard
    @NameToken(value = TASK)
    interface MyProxy extends ProxyPlace<TaskPresenter> {
    }
}