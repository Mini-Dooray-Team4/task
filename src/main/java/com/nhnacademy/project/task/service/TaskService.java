package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.TaskRegisterDto;
import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.domain.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();

    List<Task> getAllByProjectId(Integer projectId);

    TaskResponseDto getTask(Integer taskId);

    void createTask(TaskRegisterDto taskRegisterDto);

    void deleteTask(Integer taskId);

    void updateTask(TaskRegisterDto task);
}
