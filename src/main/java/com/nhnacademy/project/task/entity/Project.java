package com.nhnacademy.project.task.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Projects")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @NotBlank
    @Length(min = 3, max = 20)
    @Column(name = "user_id")
    private String userId;

    @NotBlank
    @Length(min = 3, max = 20)
    @Column(name = "project_name")
    private String projectName;

    @NotBlank
    @Column(name = "project_state")
    private String projectState;

}