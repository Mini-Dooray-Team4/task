package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.MileStone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<MileStone, Integer> {
}
