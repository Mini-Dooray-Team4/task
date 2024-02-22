package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.service.TaskService;
import com.nhnacademy.project.task.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping()
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable Integer taskId) {
        return service.getTask(taskId);
    }

    @PostMapping()
    public void createTask( @RequestBody Task task) {
        service.createTask(task);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable Integer taskId, @RequestBody Task task) {
        service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Integer taskId) {
        service.deleteTask(taskId);
    }
}