package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Pk> {
}
