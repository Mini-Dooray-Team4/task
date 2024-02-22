package com.nhnacademy.project.task.service;


import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.entity.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();
    Task getTask(Integer taskId);
    void createTask(Task task);
    void deleteTask(Integer taskId);

    void updateTask(Task task);
}
