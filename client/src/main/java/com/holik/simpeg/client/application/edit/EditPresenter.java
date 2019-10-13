package com.holik.simpeg.client.application.edit;

import com.holik.simpeg.client.application.ApplicationPresenter;
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

import static com.holik.simpeg.client.place.NameTokens.ADD;
import static com.holik.simpeg.client.place.NameTokens.EDIT;
import static com.holik.simpeg.client.place.ParameterTokens.ID;
import static com.holik.simpeg.client.util.Places.from;
import static com.holik.simpeg.client.util.Rest.popupAndLog;
import static com.holik.simpeg.client.util.Rest.using;

public class EditPresenter extends 
        Presenter<EditPresenter.MyView,
        EditPresenter.MyProxy> implements EditHandlers {

    private final PlaceManager placeManager;
    private final ResourceDelegate<TaskResource> taskDelegate;

    interface MyView extends View, HasUiHandlers<EditHandlers> {
        void setTask(Task task);

        void clearTask();
    }
    
    @ProxyStandard
    @NameToken(value = {EDIT, ADD})
    interface MyProxy extends ProxyPlace<EditPresenter> {
    }
    
    @Inject
    EditPresenter(EventBus eventBus, MyView view, MyProxy proxy, 
            PlaceManager placeManager,
                  ResourceDelegate<TaskResource> taskDelegate) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
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
        });
    }

    @Override
    public void onSave(Long id, Task task) {
        using(taskDelegate)
                .call(r -> (id != null) ? r.updateTask(id, task) : r.addTask(task))
                .onSuccess(e -> placeManager.navigateBack())
                .onFailure(popupAndLog("Cannot save task"))
                .apply();
    }

    @Override
    public void onCancel() {
        placeManager.navigateBack();
    }

  

    
}