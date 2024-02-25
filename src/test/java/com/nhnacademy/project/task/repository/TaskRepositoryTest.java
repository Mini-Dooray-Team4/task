package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.MileStone;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void getAllBy() {
        Project project = new Project(null, "gahyoung","projectName", "test중");
        MileStone milestone = new MileStone(null, "mile", LocalDateTime.now(), LocalDateTime.now(), project);
        Task task1 = new Task(null, project, "gahyoung", "taskTitle1", "taskContent1", milestone, LocalDateTime.now());
        Task task2 = new Task(null, project, "gahyoung", "taskTitle2", "taskContent2", milestone, LocalDateTime.now());

        entityManager.persistAndFlush(project);
        entityManager.persistAndFlush(milestone);
        entityManager.persistAndFlush(task1);
        entityManager.persistAndFlush(task2);

        List<TaskDto> tasks = taskRepository.getAllBy();

        assertThat(tasks).isNotEmpty();
        assertThat(tasks.size()).isEqualTo(2);
        assertThat(tasks.get(0).getTaskTitle()).isEqualTo("taskTitle1");
        assertThat(tasks.get(1).getTaskTitle()).isEqualTo("taskTitle2");
    }

    @Test
    void getByTaskId() {
        Project project2 = new Project(null, "gahyoung","projectName", "test중");
        MileStone milestone2 = new MileStone(null, "mile", LocalDateTime.now(), LocalDateTime.now(), project2);
        Task task3 = new Task(null, project2, "gahyoung", "taskTitle3", "taskContent3", milestone2, LocalDateTime.now());
        entityManager.persistAndFlush(project2);
        entityManager.persistAndFlush(milestone2);
        entityManager.persistAndFlush(task3);

        Optional<TaskResponseDto> task = taskRepository.getByTaskId(task3.getTaskId());

        assertThat(task).isPresent();
        assertThat(task.get().getTaskTitle()).isEqualTo("taskTitle3");
    }

    @Test
    void getAllByProject_ProjectId() {
        Project project3 = new Project(null, "gahyoung","projectName3", "종료");
        MileStone milestone3 = new MileStone(null, "mile", LocalDateTime.now(), LocalDateTime.now(), project3);
        Task task4 = new Task(null, project3, "userId1", "taskTitle1", "taskContent1", milestone3, LocalDateTime.now());
        Task task5 = new Task(null, project3, "userId1", "taskTitle1", "taskContent1", milestone3, LocalDateTime.now());
        Task task6 = new Task(null, project3, "userId1", "taskTitle1", "taskContent1", milestone3, LocalDateTime.now());

        entityManager.persistAndFlush(project3);
        entityManager.persistAndFlush(milestone3);
        entityManager.persistAndFlush(task4);
        entityManager.persistAndFlush(task5);
        entityManager.persistAndFlush(task6);

        List<Task> tasks = taskRepository.getAllByProject_ProjectId(project3.getProjectId());

        assertThat(tasks).isNotEmpty();
        assertThat(tasks.size()).isEqualTo(3);
        assertThat(tasks.get(0).getProject().getProjectName()).isEqualTo("projectName3");
        assertThat(tasks.get(1).getProject().getProjectState()).isEqualTo("종료");
    }
}