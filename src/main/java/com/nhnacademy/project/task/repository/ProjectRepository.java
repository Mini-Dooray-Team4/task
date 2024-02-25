package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<ProjectDto> getAllBy();
    ProjectDto getByProjectId(Integer projectId);
}
