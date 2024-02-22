package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
