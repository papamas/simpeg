package com.holik.simpeg.client.application.task;

import com.holik.simpeg.shared.entity.Task;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

class TaskView extends ViewWithUiHandlers<TaskHandlers> implements TaskPresenter.MyView {
    
    @UiField
    MaterialLabel message;
    
    
    @UiField
    MaterialRow content;
    
    @UiField
    MaterialTextBox title;
    
    
    @UiField
    MaterialTextArea text;

    private Task task;

    @Inject
    TaskView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void clearTask() {
        task = null;
        title.setText("");
        text.setText("");
        message.setVisible(true);
        content.setVisible(false);
    }

    @Override
    public void setTask(Task task) {
        this.task = task;
        title.setText(task.getTitle());
        text.setText(task.getText());
        message.setVisible(false);
        content.setVisible(true);
    }

    @UiHandler("edit")
    public void editClick(ClickEvent event) {
        getUiHandlers().onEdit(task.getId());
    }

    @UiHandler("delete")
    public void deleteClick(ClickEvent event) {
        getUiHandlers().onDelete(task.getId());
    }

    @UiHandler("back")
    public void backClick(ClickEvent event) {
        getUiHandlers().onBack();
    }

    interface Binder extends UiBinder<Widget, TaskView> {
    }
}
