package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.entity.TaskMileStone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskMileStoneRepository extends JpaRepository<TaskMileStone, TaskMileStone.Pk> {

}
