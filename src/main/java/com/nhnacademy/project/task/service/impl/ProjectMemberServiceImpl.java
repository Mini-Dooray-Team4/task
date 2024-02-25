package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.repository.ProjectMemberRepository;
import com.nhnacademy.project.task.service.ProjectMemberService;
import com.nhnacademy.project.task.entity.ProjectMember;

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
    public ProjectMember getProjectMember(ProjectMember.Pk pk) {
        return repository.findById(pk).orElse(null);
    }

    @Override
    public void createProjectMember(ProjectMemberRegisterDto projectMemberRegisterDto) {
        Project project = projectRepository.findById(projectMemberRegisterDto.getProjectId()).orElse(null);
        for (String userId : projectMemberRegisterDto.getUserId()) {
            ProjectMember projectMember = new ProjectMember();

            projectMember.setProject(project);

            ProjectMember.Pk pk = new ProjectMember.Pk(projectMemberRegisterDto.getProjectId(), userId);

            projectMember.setPk(pk);
            repository.save(projectMember);
        }

    }

    @Override
    public void deleteProjectMember(ProjectMember.Pk pk) {
        repository.deleteById(pk);
    }

    @Override
    public void updateProjectMember(ProjectMember projectMember) {
        if (repository.existsById(projectMember.getPk())) {
            repository.save(projectMember);
        }
    }
}