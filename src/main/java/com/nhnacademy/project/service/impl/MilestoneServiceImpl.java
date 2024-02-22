package com.nhnacademy.project.service.impl;

import com.nhnacademy.project.repository.MilestoneRepository;
import com.nhnacademy.project.service.MilestoneService;
import com.nhnacademy.project.entity.MileStone;
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