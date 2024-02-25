package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {


    List<ProjectDto> getAllBy();
    ProjectDto getByProjectId(Integer projectId);

    @Modifying
    @Query("update Project p set p.projectName = ?1 where p.projectId=?2 ")
    void updateByProjectId(String projectName, Integer projectId);
}
