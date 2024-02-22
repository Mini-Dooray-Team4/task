package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.entity.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskDto> findAllBy();

    TaskDto findByTaskId(Integer taskId);
}
