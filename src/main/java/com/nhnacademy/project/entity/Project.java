package com.nhnacademy.project.entity;


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
    private Integer userId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_state")
    private String projectState;

    public Project(Integer userId, String projectName, String projectState) {
        this.userId = userId;
        this.projectName = projectName;
        this.projectState = projectState;
    }
}