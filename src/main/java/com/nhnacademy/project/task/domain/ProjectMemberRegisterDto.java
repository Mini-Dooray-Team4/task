package com.nhnacademy.project.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectMemberRegisterDto {
    private Integer projectId;
    private String userId;
}
