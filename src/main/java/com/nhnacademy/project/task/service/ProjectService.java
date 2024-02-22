package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectByProjectId(Integer projectId);
    void createProject(Project project);
    void deleteProject(Integer projectId);

    void updateProject(Project project);
}
