package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.ProjectMemberRegisterDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.repository.ProjectMemberRepository;
import com.nhnacademy.project.task.repository.ProjectRepository;
import com.nhnacademy.project.task.service.ProjectMemberService;
import com.nhnacademy.project.task.entity.ProjectMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private final ProjectMemberRepository repository;
    private final ProjectRepository projectRepository;

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
        ProjectMember projectMember = new ProjectMember();

        projectMember.setProject(project);
        projectMember.setUserId(projectMemberRegisterDto.getUserId());

        ProjectMember.Pk pk = new ProjectMember.Pk(projectMemberRegisterDto.getProjectId());

        projectMember.setPk(pk);
        log.info(">>>>>>>>>{}",projectMember);
        repository.save(projectMember);
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