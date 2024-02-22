package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProject(Integer projectId);
    void createProject(Project project);
    void deleteProject(Integer projectId);

    void updateProject(Project project);
}
