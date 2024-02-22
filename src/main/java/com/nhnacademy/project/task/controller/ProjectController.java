package com.nhnacademy.project.task.controller;


import com.nhnacademy.project.task.service.ProjectService;
import com.nhnacademy.project.task.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;
    @GetMapping
    public List<Project> getAllProjects()
    {
        return service.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Project getProject(@PathVariable Integer projectId) {
        return service.getProject(projectId);
    }

    @PostMapping
    public void createProject(@RequestBody Project project) {
        service.createProject(project);
    }

    @PutMapping("/{projectId}")
    public void updateProject(@RequestBody Project project) {
        service.updateProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Integer projectId) {
        service.deleteProject(projectId);
    }
}
