package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.entity.TaskDto;
import com.nhnacademy.project.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskControllerTest {


    @Autowired
    private TaskService taskService;

    @Test
    void getAllTasks() {
        TaskDto testTag = new TaskDto(1, "taskTitle", "100");
        List<TaskDto> tasks = taskService.getAllTasks();
        assertThat(tasks).contains(testTag);
    }

//    @Test
//    void getTask() {
//        Project project = new Project("100", "testProject", "진행중");
//        entityManager.persist(project);
//
//        Task task = new Task(project, "taskName", "taskTitle", "taskContent", LocalDate.now());
//        entityManager.persist(task);
//
//        Task actual = taskService.getTask(task.getTaskId());
//
//        assertNotNull(actual);
//        assertEquals(task.getTaskId(), actual.getTaskId());
//    }
//
//    @Test
//    void createTask() {
//        Project project = new Project("100", "testProject", "진행중");
//        entityManager.persist(project);
//
//        Task task = new Task(project, "taskName", "taskTitle", "taskContent", LocalDate.now());
//
//        taskService.createTask(task);
//
//        assertNotNull(task.getTaskId());
//    }
//
//    @Test
//    void updateTask() {
//        Project project = new Project("100", "testProject", "진행중");
//        entityManager.persist(project);
//
//        Task task = new Task(project, "taskName", "taskTitle", "taskContent", LocalDate.now());
//        entityManager.persist(task);
//
//        task.setTaskTitle("Updated Title");
//        taskService.updateTask(task);
//
//        Task updatedTask = entityManager.find(Task.class, task.getTaskId());
//        assertEquals("Updated Title", updatedTask.getTaskTitle());
//    }
//
//    @Test
//    void deleteTask() {
//    }
}