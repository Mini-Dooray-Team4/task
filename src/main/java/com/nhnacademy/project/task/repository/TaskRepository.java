package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.domain.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskDto> getAllBy();

    Optional<TaskDto> getByTaskId(Integer taskId);
}
