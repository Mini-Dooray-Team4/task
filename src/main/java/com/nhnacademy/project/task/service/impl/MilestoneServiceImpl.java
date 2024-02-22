package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.repository.MilestoneRepository;
import com.nhnacademy.project.task.service.MilestoneService;
import com.nhnacademy.project.task.entity.MileStone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository repository;

    @Override
    public List<MileStone> getAllMilestones() {
        return repository.findAll();
    }

    @Override
    public MileStone getMilestone(Integer milestoneId) {
        return repository.findById(milestoneId).orElse(null);
    }

    @Override
    public void createMilestone(MileStone milestone) {
        repository.save(milestone);
    }

    @Override
    public void deleteMilestone(Integer milestoneId) {
        repository.deleteById(milestoneId);
    }

    @Override
    public void updateMilestone(MileStone milestone) {
        if (repository.existsById(milestone.getMileStoneId())) {
            repository.save(milestone);
        }
    }
}