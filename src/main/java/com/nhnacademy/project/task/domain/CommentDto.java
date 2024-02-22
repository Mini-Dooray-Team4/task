package com.nhnacademy.project.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentDto {
    String userId;
    LocalDateTime createAt;
    String content;
}
