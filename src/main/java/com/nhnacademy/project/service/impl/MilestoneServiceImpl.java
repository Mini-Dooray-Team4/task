package com.nhnacademy.project.service.impl;

import com.nhnacademy.project.repository.MilestoneRepository;
import com.nhnacademy.project.service.MilestoneService;
import entity.Milestone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository repository;

    @Override
    public List<Milestone> getAllMilestones() {
        return repository.findAll();
    }

    @Override
    public Milestone getMilestone(Integer milestoneId) {
        return repository.findById(milestoneId).orElse(null);
    }

    @Override
    public void createMilestone(Milestone milestone) {
        repository.save(milestone);
    }

    @Override
    public void deleteMilestone(Integer milestoneId) {
        repository.deleteById(milestoneId);
    }

    @Override
    public void updateMilestone(Milestone milestone) {
        if (repository.existsById(milestone.getId())) {
            repository.save(milestone);
        }
    }
}