package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.Task;
import com.nhnacademy.project.task.entity.TaskMileStone;

import java.util.List;

public interface TaskMileStoneService {
    List<TaskMileStone> getAllTaskMileStones();
    TaskMileStone getTaskMileStone(Task task);
    void createTaskMileStone(TaskMileStone taskMileStone);
    void deleteTaskMileStone(Task task);

    void updateTaskMileStone(TaskMileStone taskMileStone);
}
