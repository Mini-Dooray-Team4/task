package com.nhnacademy.project.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRegisterDto {
    private Integer projectId;
    private String tagName;
}
