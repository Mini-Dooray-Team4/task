package com.nhnacademy.project.task.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_state")
    private String projectState;

}