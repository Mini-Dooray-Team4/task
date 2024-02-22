package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
