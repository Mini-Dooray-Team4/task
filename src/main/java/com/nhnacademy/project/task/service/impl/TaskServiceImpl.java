package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.domain.TaskRegisterDto;
import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.repository.TaskRepository;
import com.nhnacademy.project.task.service.TaskService;
import com.nhnacademy.project.task.entity.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service("taskService")
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public List<TaskDto> getAllTasks() {
        return repository.getAllBy();
    }

    @Override
    public List<TaskDto> getAllByProjectId(Integer projectId) {
        return repository.getAllByProject_ProjectId(projectId);
    }

    @Override
    public TaskResponseDto getTask(Integer taskId) {
        return repository.getByTaskId(taskId).orElse(null);
    }

    @Override
    public void createTask(TaskRegisterDto taskRegisterDto) {
        log.info("{}", taskRegisterDto);
        Task task = new Task();
        BeanUtils.copyProperties(taskRegisterDto, task);
        task.setCreateAt(LocalDateTime.now());
        task.setTaskContent("");
        Project project = new Project();
        project.setProjectId(taskRegisterDto.getProjectId());
        task.setProject(project);
        repository.save(task);
    }

    @Override
    public void deleteTask(Integer taskId) {
        if (repository.existsById(taskId))
            repository.deleteById(taskId);
    }

    @Override
    public void updateTask(TaskRegisterDto registerDto) {
        Task task = new Task();
        BeanUtils.copyProperties(registerDto, task);

        task.setCreateAt(LocalDateTime.now());

        if (repository.existsById(task.getTaskId()))
            repository.save(task);
    }
}
