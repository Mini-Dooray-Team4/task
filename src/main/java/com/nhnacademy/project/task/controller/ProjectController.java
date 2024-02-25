package com.nhnacademy.project.task.controller;


import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.domain.ProjectMemberRegisterDto;
import com.nhnacademy.project.task.domain.ProjectRegisterDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.ProjectMember;
import com.nhnacademy.project.task.service.ProjectMemberService;
import com.nhnacademy.project.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity
                .ok()
                .body(projectService.getAllProjects());
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Integer projectId) {
        return ResponseEntity
                .ok()
                .body(projectService.getProjectByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody ProjectRegisterDto projectRegisterDto) {
        Project project=projectService.createProject(projectRegisterDto);
        ProjectMemberRegisterDto projectMemberRegisterDto = new ProjectMemberRegisterDto(project.getProjectId(), projectRegisterDto.getUserId());
        projectMemberService.createProjectMember(projectMemberRegisterDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
