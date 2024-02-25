package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.domain.ProjectModifyDto;
import com.nhnacademy.project.task.domain.ProjectRegisterDto;
import com.nhnacademy.project.task.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectByProjectId(Integer projectId);
    void createProject(ProjectRegisterDto projectRegisterDto);
    void deleteProject(Integer projectId);

    void updateProject(ProjectModifyDto projectModifyDto);
}
