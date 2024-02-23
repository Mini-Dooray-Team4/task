package com.nhnacademy.project.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private TaskRepository repository;


    @Test
    void getAllTasks() throws Exception {
        given(repository.getAllBy()).willReturn(List.of(new TaskDto(1, "taskTitle", "jjunho50")));

        mockMvc.perform(get("/task"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].taskTitle", equalTo("taskTitle")));
    }

    @Test
    void findByTaskId() throws Exception {
        given(repository.getByTaskId(1)).willReturn(Optional.of(new TaskDto(1, "taskTitle", "jjunho50")));

        mockMvc.perform(get("/task/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.taskTitle", equalTo("taskTitle")))
                .andExpect(jsonPath("$.userId", equalTo("jjunho50")));
    }

    @Test
    void createTask() throws Exception {
        Project project = new Project(1, "jjunho50", "name", "state");
        Task task = new Task(1, project, "jjunho50", "title", "content", LocalDateTime.now());

        given(repository.save(any(Task.class)))
                .willReturn(new Task(1, project, "jjunho50", "taskTitle", "jjunho50", LocalDateTime.now()));

        mockMvc.perform(
                post("/task")
                        .content(objectMapper.writeValueAsString(task))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateComment() throws Exception {
        Project project = new Project(1,"jjunho50", "name", "state");
        Task task = new Task(1, project, "jjunho50", "title", "content", LocalDateTime.now());

        String updatedProjectJson = objectMapper.writeValueAsString(task);

        mockMvc.perform(
                put("/task/{taskId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedProjectJson))
                .andExpect(status().isOk());
    }

    @Test
    void deleteComment() throws Exception {
        mockMvc.perform(
                delete("/task/{taskId}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}