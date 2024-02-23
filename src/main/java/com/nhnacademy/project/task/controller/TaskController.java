package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.domain.TaskRegisterDto;
import com.nhnacademy.project.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }


    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TaskDto>> getAllTasksByProjectId(@PathVariable Integer projectId)
    {
        return ResponseEntity.ok().body(taskService.getAllByProjectId(projectId));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(taskService.getTask(taskId));
    }

    @PostMapping()
    public ResponseEntity<Void> createTask(@RequestBody TaskRegisterDto task) {

       taskService.createTask(task);

       return ResponseEntity.ok().build();
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Void> updateTask(@RequestBody TaskRegisterDto task) {
        taskService.updateTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}