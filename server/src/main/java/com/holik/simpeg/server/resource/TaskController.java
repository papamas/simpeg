package com.holik.simpeg.server.resource;

import com.holik.simpeg.server.repository.TaskRepository;
import com.holik.simpeg.shared.entity.Task;
import com.holik.simpeg.shared.resource.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController implements TaskResource {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(new Task(task.getTitle(), task.getText()));
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existing = taskRepository.findById(id).get();
        existing.setText(task.getText());
        existing.setTitle(task.getTitle());
        return taskRepository.save(existing);
    }

    @Override
    public Void deleteTask(Long id) {
        taskRepository.deleteById(id);
        return null;
    }

}
