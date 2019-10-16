package com.holik.simpeg.client.application.list;

import com.google.gwt.event.dom.client.ClickEvent;
import com.holik.simpeg.shared.entity.Task;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialToast;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.ListGroup;
import org.gwtbootstrap3.client.ui.ListGroupItem;
import org.gwtbootstrap3.client.ui.base.HasHref;
   

class ListView extends ViewWithUiHandlers<ListHandlers> implements ListPresenter.MyView {
    @UiField
    MaterialLabel message;
    
    /*
    @UiField
    MaterialListValueBox<Task> listBox;
    */
    
    @Inject
    ListView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    
   
    @Override
    public void setTasks(Iterable<Task> tasks) {
        /*
        listBox.addValueChangeHandler(valueChangeEvent -> 
                MaterialToast.fireToast("VALUE [ " +
                        valueChangeEvent.getValue().getTitle() + " ]"));
        for (Task task : .getAllHeroes()) {
            listBox.addItem(hero, hero.getName());
        }
        //this.tasks.clear();
        */
        
        /*
        ListHandlers handlers = getUiHandlers();
        for(Task task : tasks) {
            ListGroupItem item = new ListGroupItem();
            Anchor a = new Anchor(task.getTitle(), HasHref.EMPTY_HREF);
            a.addClickHandler(e -> {
                handlers.viewTask(task.getId());
            });
            item.add(a);
            this.tasks.add(item);
        }
        
        if (message.getElement().getStyle() != null) {
            message.setVisible(this.tasks.getWidgetCount() == 0);
        }*/
        
    }

    
    @UiHandler("add")
    public void onAddClick(ClickEvent event) {
        getUiHandlers().onAdd();
    }

    @UiHandler("refresh")
    public void onRefreshClick(ClickEvent event) {
        getUiHandlers().onRefresh();
    }

    interface Binder extends UiBinder<Widget, ListView> {
    }

     
    
}
