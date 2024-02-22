package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
