package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.repository.ProjectRepository;
import com.nhnacademy.project.task.service.ProjectService;
import com.nhnacademy.project.task.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    @Override
    public List<ProjectDto> getAllProjects() {

        return repository.getAllBy();
    }

    @Override
    public ProjectDto getProjectByProjectId(Integer projectId) {
        return repository.getByProjectId(projectId);
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
        if (repository.existsById(project.getProjectId())) {
            repository.save(project);
        }
    }
}
