package com.nhnacademy.project.service;

import entity.Milestone;

import java.util.List;

public interface MilestoneService {
    List<Milestone> getAllMilestones();
    Milestone getMilestone(Integer milestoneId);
    void createMilestone(Milestone milestone);
    void deleteMilestone(Integer milestoneId);

    void updateMilestone(Milestone milestone);
}
