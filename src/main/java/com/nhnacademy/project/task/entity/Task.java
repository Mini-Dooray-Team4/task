package com.nhnacademy.project.task.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    public Task(Project project, String userId, String taskTitle, String taskContent, LocalDateTime createAt) {
        this.project = project;
        this.userId = userId;
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
        this.createAt = createAt;
    }

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
    private LocalDateTime createAt;



}