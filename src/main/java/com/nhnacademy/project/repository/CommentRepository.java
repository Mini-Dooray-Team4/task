package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
