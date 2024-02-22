package com.nhnacademy.project.task.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_state")
    private String projectState;

}