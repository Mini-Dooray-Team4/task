package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTag.Pk> {
}
