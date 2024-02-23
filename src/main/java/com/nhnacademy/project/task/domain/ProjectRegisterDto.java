package com.nhnacademy.project.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectRegisterDto {
    private String userId;
    private Integer projectId;
    private String projectName;
}
