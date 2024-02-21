package com.nhnacademy.project.service.impl;

import com.nhnacademy.project.repository.ProjectRepository;
import com.nhnacademy.project.service.ProjectService;
import entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public Project getProject(Integer projectId) {
        return repository.findById(projectId).orElse(null);
    }

    @Override
    public void createProject(Project project) {
        repository.save(project);
    }

    @Override
    public void deleteProject(Integer projectId) {
        repository.deleteById(projectId);
    }

    @Override
    public void updateProject(Project project) {
        if (repository.existsById(project.getId())) {
            repository.save(project);
        }
    }
}
