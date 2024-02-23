package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.domain.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<TaskDto> getAllBy();

    @Query(value = "select new com.nhnacademy.project.task.domain.TaskResponseDto(t.taskId,p.projectId,t.userId ,t.taskTitle, t.taskContent,t.createAt) " +
            "from Task t " +
            "inner join fetch Project p on t.project = p " +
            "where t.taskId=?1")
    Optional<TaskResponseDto> getByTaskId(Integer taskId);


    List<Task> getAllByProject_ProjectId(Integer projectId);
}
