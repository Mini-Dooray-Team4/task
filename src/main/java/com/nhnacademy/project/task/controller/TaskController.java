package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.service.TaskService;
import com.nhnacademy.project.task.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok().body(service.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(service.getTask(taskId));
    }

    @PostMapping()
    public void createTask(@RequestBody Task task) {
        service.createTask(task);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@RequestBody Task task) {
        service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Integer taskId) {
        service.deleteTask(taskId);
    }
}