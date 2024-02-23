package com.nhnacademy.project.task.controller;


import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.service.ProjectService;
import com.nhnacademy.project.task.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity
            .ok()
            .body(service.getAllProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Integer projectId) {
        return ResponseEntity
                .ok()
                .body(service.getProjectByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody ProjectDto projectDto) {
        service.createProject(projectDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> updateProject(@RequestBody Project project) {
        service.updateProject(project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer projectId) {
        service.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
