package com.nhnacademy.project.service;

import com.nhnacademy.project.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProject(Integer projectId);
    void createProject(Project project);
    void deleteProject(Integer projectId);

    void updateProject(Project project);
}
