package com.nhnacademy.project.service.impl;

import com.nhnacademy.project.repository.TaskRepository;
import com.nhnacademy.project.service.TaskService;
import com.nhnacademy.project.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTask(Integer taskId) {
        return repository.findById(taskId).orElse(null);
    }

    @Override
    public void createTask(Task task) {
        repository.save(task);
    }

    @Override
    public void deleteTask(Integer taskId) {
        repository.deleteById(taskId);
    }

    @Override
    public void updateTask(Task task) {
        if (repository.existsById(task.getTaskId())) {
            repository.save(task);
        }
    }
}
