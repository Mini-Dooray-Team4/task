package com.nhnacademy.project.task.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class ProjectServiceImplTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllProjects() throws Exception{
        mockMvc.perform(get("/project"))
                .andExpect(status().isOk());
    }

//    @Test
//    void getProject() {
//    }
//
//    @Test
//    void createProject() {
//    }
//
//    @Test
//    void deleteProject() {
//    }
//
//    @Test
//    void updateProject() {
//    }
}