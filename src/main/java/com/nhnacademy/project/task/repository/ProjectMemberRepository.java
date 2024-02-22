package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Pk> {
}
