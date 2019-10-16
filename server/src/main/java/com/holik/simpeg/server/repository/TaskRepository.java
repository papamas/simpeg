package com.holik.simpeg.server.repository;

import com.holik.simpeg.shared.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository 
        extends CrudRepository<Task, Long> {
}
