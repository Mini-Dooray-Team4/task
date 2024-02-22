package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.TaskApplication;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes = TaskApplication.class)
@AutoConfigureMockMvc
class ProjectControllerTest {

    @MockBean
    ProjectRepository projectRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void projectRepository() throws Exception {

        given(projectRepository.findAll())
                .willReturn(List.of(new Project(1, "testProject", "test싱테")));

        mockMvc.perform(get("/project"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].projectName", equalTo("testProject"))
                );
    }

    @Test
    void getProject() {
    }

    @Test
    void createProject() {
    }

    @Test
    void updateProject() {
    }

    @Test
    void deleteProject() {
    }
}