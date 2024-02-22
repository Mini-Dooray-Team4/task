package com.nhnacademy.project.task.service;


import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.domain.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto getTask(Integer taskId);
    void createTask(Task task);
    void deleteTask(Integer taskId);

    void updateTask(Task task);
}
