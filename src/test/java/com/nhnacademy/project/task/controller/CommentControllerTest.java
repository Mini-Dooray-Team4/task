package com.nhnacademy.project.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.project.task.TaskApplication;
import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.domain.ProjectDto;
import com.nhnacademy.project.task.entity.Comment;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TaskApplication.class)
@AutoConfigureMockMvc
class CommentControllerTest {

    @MockBean
    CommentService commentService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllComments() throws Exception {
        given(commentService.getAllComments())
                .willReturn(List.of(new CommentDto("testId", LocalDateTime.now(), "testContent")));

        mockMvc.perform(get("/comment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", equalTo("testContent"))
                );
    }

    @Test
    void getComment() throws Exception {
        given(commentService.getComment(2))
                .willReturn(new CommentDto("testId2", LocalDateTime.now(), "testContent2"));

        mockMvc.perform(get("/comment/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", equalTo("testContent2"))
                );
    }

    @Test
    void createComment() throws Exception {
        Project project = new Project(1,"3", "project", "진행중");
        Task task = new Task(1,project, "aa", "taskTitle", "taskContent", LocalDateTime.now());
        Comment comment = new Comment(10, "userId", project, task, "content", LocalDateTime.now());

        mockMvc.perform(
                        post("/comment")
                                .content(objectMapper.writeValueAsString(comment))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());


    }

    @Test
    void updateComment() throws Exception {
        Project project = new Project(1,"3", "project", "진행중");
        Task task = new Task(1,project, "aa", "taskTitle", "taskContent", LocalDateTime.now());
        Comment comment = new Comment(10, "userId", project, task, "updateComment", LocalDateTime.now());

        String updatedProjectJson = objectMapper.writeValueAsString(comment);

        mockMvc.perform(
                        put("/comment/{commentId}", 10)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updatedProjectJson)
                )
                .andExpect(status().isOk());
    }

    @Test
    void deleteComment() throws Exception {
        mockMvc.perform(
                        delete("/comment/{commentId}", 10)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }
}