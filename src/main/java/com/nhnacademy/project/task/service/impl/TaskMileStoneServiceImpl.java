package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.entity.TaskMileStone;
import com.nhnacademy.project.task.repository.TaskMileStoneRepository;
import com.nhnacademy.project.task.service.TaskMileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskMileStoneServiceImpl implements TaskMileStoneService {
    private final TaskMileStoneRepository repository;

    @Override
    public List<TaskMileStone> getAllTaskMileStones() {
        return repository.findAll();
    }

    @Override
    public TaskMileStone getTaskMileStone(TaskMileStone.Pk pk) {
        Optional<TaskMileStone> taskMileStone = repository.findById(pk);
        return taskMileStone.orElse(null);
    }

    @Override
    public void createTaskMileStone(TaskMileStone taskMileStone) {
        repository.save(taskMileStone);
    }

    @Override
    public void deleteTaskMileStone(TaskMileStone.Pk pk) {
        repository.deleteById(pk);
    }

    @Override
    public void updateTaskMileStone(TaskMileStone taskMileStone) {
        repository.save(taskMileStone);
    }
}