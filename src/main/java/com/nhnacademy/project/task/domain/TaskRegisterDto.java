package com.nhnacademy.project.task.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskRegisterDto {
    private Integer taskId;
    private Integer projectId;
    private String userId;
    private String taskTitle;
}
