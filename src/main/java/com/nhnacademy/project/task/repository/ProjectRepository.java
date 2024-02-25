package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {


    @Query("select new com.nhnacademy.project.task.domain.ProjectDto(p.projectId,p.projectName) " +
            "from Project p " +
            "inner join ProjectMember pm on p.projectId = pm.project.projectId " +
            "where pm.pk.userId=?1")
    List<ProjectDto> getAllBy(String userId);
    ProjectDto getByProjectId(Integer projectId);

    @Modifying
    @Query("update Project p set p.projectName = ?1 where p.projectId=?2 ")
    void updateByProjectId(String projectName, Integer projectId);
}
