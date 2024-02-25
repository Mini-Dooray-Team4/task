package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.domain.ProjectMemberRegisterDto;
import com.nhnacademy.project.task.domain.ProjectModifyDto;
import com.nhnacademy.project.task.domain.ProjectRegisterDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        return ResponseEntity
                .ok()
                .body(projectService.getAllProjects(userId));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Integer projectId) {

        return ResponseEntity
                .ok()
                .body(projectService.getProjectByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody ProjectRegisterDto projectRegisterDto) {
        Project project = projectService.createProject(projectRegisterDto);
        ProjectMemberRegisterDto projectMemberRegisterDto = new ProjectMemberRegisterDto(project.getProjectId(),
                List.of(projectRegisterDto.getUserId()));
        projectMemberService.createProjectMember(projectMemberRegisterDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> updateProject(@RequestBody ProjectModifyDto projectModifyDto) {
        projectService.updateProject(projectModifyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{projectId}/member/invite")
    private ResponseEntity<Void> inviteProjectMember(@RequestBody ProjectMemberRegisterDto projectMemberRegisterDto) {
        projectMemberService.createProjectMember(projectMemberRegisterDto);

        return null;
    }

}
