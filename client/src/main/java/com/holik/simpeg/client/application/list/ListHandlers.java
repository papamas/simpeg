package com.holik.simpeg.client.application.list;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ListHandlers extends UiHandlers {
    void viewTask(Long id);

    void onAdd();

    void onRefresh();
}
