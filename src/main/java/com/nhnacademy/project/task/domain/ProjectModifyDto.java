package com.nhnacademy.project.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectModifyDto {
    private Integer projectId;
    private String projectName;
}
