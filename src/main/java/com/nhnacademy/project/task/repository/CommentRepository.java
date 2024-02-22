package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
