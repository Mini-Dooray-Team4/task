package com.nhnacademy.project.repository;

import entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer> {
}
