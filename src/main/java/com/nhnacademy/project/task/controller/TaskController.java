package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.TagRegisterDto;
import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.domain.TaskRegisterDto;
import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Task>> getAllTasksByProjectId(@PathVariable Integer projectId) {
        List<Task> actual = taskService.getAllByProjectId(projectId);
        return ResponseEntity.ok().body(actual);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok().body(taskService.getTask(taskId));
    }

    @PostMapping()
    public void createTask(@RequestBody TaskRegisterDto taskRegisterDto) {
        taskService.createTask(taskRegisterDto);
    }
    @PostMapping("/tag/register")
    public void createTag(@RequestBody TagRegisterDto tagRegisterDto) {
        taskService.createTag(tagRegisterDto);
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