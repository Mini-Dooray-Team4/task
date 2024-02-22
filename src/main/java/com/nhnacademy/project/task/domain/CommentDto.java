package com.nhnacademy.project.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CommentDto {
    String userId;
    LocalDate createAt;
    String content;
}
