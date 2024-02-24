package com.nhnacademy.project.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.project.task.TaskApplication;
import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
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
        given(commentService.getAllComments(anyInt(), anyInt()))
                .willReturn(List.of(new CommentDto("testId", LocalDateTime.now(), "testContent")));

        mockMvc.perform(get("/project/1/task/1/comment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", equalTo("testContent"))
                );
    }

    @Test
    void getComment() throws Exception {
        given(commentService.getComment(anyInt(), anyInt(), anyInt()))
                .willReturn(Optional.of(new CommentDto("testId2", LocalDateTime.now(), "testContent2")));

        mockMvc.perform(get("/project/1/task/1/comment/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", equalTo("testContent2"))
                );
    }

    @Test
    void createComment() throws Exception {
        Comment comment = new Comment(10, "userId", new Project(), new Task(), "content", LocalDateTime.now());

        mockMvc.perform(
                        post("/project/1/task/1/comment")
                                .content(objectMapper.writeValueAsString(comment))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());


    }

    @Test
    void updateComment() throws Exception {
        Comment comment = new Comment(10, "userId", new Project(), new Task(), "updateComment", LocalDateTime.now());

        String updatedProjectJson = objectMapper.writeValueAsString(comment);

        mockMvc.perform(
                        put("/project/1/task/1/comment/10", 10)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updatedProjectJson)
                )
                .andExpect(status().isOk());
    }

    @Test
    void deleteComment() throws Exception {
        mockMvc.perform(
                        delete("/project/1/task/1/comment/10", 10)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }
}