package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTag.pk> {
}
