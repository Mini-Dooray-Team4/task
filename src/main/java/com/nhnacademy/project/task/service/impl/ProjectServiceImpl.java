package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.domain.ProjectModifyDto;
import com.nhnacademy.project.task.domain.ProjectRegisterDto;
import com.nhnacademy.project.task.repository.ProjectRepository;
import com.nhnacademy.project.task.service.ProjectService;
import com.nhnacademy.project.task.entity.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getAllProjects() {
        log.info("{}", "getAllProjects");

        return repository.getAllBy();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getProjectByProjectId(Integer projectId) {
        log.info("{}", "getProjectByProjectId");

        return repository.getByProjectId(projectId);
    }

    @Override
    public Project createProject(ProjectRegisterDto projectRegisterDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectRegisterDto, project);
        project.setProjectId(null);
        project.setProjectState("활동");
        return repository.save(project);
    }

    @Override
    public void deleteProject(Integer projectId) {
        repository.deleteById(projectId);
    }

    @Override
    public void updateProject(ProjectModifyDto projectModifyDto) {
        if (repository.existsById(projectModifyDto.getProjectId())) {
            log.info("{}",projectModifyDto);
            repository.updateByProjectId(projectModifyDto.getProjectName(), projectModifyDto.getProjectId());
        }
    }
}