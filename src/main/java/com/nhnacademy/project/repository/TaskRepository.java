package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
