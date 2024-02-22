package com.nhnacademy.project.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "create_at")
    private LocalDate createAt;
}