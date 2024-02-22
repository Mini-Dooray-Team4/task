package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.TaskMileStone;

import java.util.List;

public interface TaskMileStoneService {
    List<TaskMileStone> getAllTaskMileStones();
    TaskMileStone getTaskMileStone(TaskMileStone.Pk pk);
    void createTaskMileStone(TaskMileStone taskMileStone);
    void deleteTaskMileStone(TaskMileStone.Pk pk);

    void updateTaskMileStone(TaskMileStone taskMileStone);
}
