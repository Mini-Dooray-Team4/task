package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.MileStone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<MileStone, Integer> {
}
