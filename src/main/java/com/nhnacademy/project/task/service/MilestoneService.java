package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.MileStone;

import java.util.List;

public interface MilestoneService {
    List<MileStone> getAllMilestones();
    MileStone getMilestone(Integer milestoneId);
    void createMilestone(MileStone milestone);
    void deleteMilestone(Integer milestoneId);

    void updateMilestone(MileStone milestone);
}
