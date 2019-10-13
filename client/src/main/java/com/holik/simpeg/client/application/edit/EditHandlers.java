package com.holik.simpeg.client.application.edit;

import com.holik.simpeg.shared.entity.Task;
import com.gwtplatform.mvp.client.UiHandlers;

public interface EditHandlers extends UiHandlers {
    void onSave(Long id, Task task);

    void onCancel();
}
