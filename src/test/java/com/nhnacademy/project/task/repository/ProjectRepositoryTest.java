package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void getAllBy() {
        Project project1 = new Project(null, "gahyoung","Project 1", "진행중");
        Project project2 = new Project(null, "gahyoung","Project 2", "종료");

        testEntityManager.persist(project1);
        testEntityManager.persist(project2);
        List<ProjectDto> projects = projectRepository.getAllBy();

        assertThat(projects).isNotNull();
        assertTrue(projects.size() >= 2);
    }

    @Test
    void getByProjectId() {
        Project project3 = new Project(null,"gahyoung", "Project 3", "보류");

        testEntityManager.persist(project3);
        ProjectDto project = projectRepository.getByProjectId(project3.getProjectId());

        assertThat(project).isNotNull();
        assertThat(project.getProjectName()).isEqualTo("Project 3");
    }
}