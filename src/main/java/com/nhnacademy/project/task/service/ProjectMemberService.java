package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getAllProjectMembers();
    ProjectMember getProjectMember(ProjectMember.Pk pk);
    void createProjectMember(ProjectMember projectMember);
    void deleteProjectMember(ProjectMember.Pk pk);

    void updateProjectMember(ProjectMember projectMember);
}
