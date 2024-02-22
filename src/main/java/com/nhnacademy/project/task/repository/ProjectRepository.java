package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
