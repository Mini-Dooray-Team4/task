package com.nhnacademy.project.service.impl;

import com.nhnacademy.project.repository.ProjectMemberRepository;
import com.nhnacademy.project.service.ProjectMemberService;
import entity.ProjectMember;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private final ProjectMemberRepository repository;

    @Override
    public List<ProjectMember> getAllProjectMembers() {
        return repository.findAll();
    }

    @Override
    public ProjectMember getProjectMember(Integer projectMemberId) {
        return repository.findById(projectMemberId).orElse(null);
    }

    @Override
    public void createProjectMember(ProjectMember projectMember) {
        repository.save(projectMember);
    }

    @Override
    public void deleteProjectMember(Integer projectMemberId) {
        repository.deleteById(projectMemberId);
    }

    @Override
    public void updateProjectMember(ProjectMember projectMember) {
        if (repository.existsById(projectMember.getId())) {
            repository.save(projectMember);
        }
    }
}