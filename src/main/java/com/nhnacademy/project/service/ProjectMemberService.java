package com.nhnacademy.project.service;

import com.nhnacademy.project.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getAllProjectMembers();
    ProjectMember getProjectMember(ProjectMember.Pk pk);
    void createProjectMember(ProjectMember projectMember);
    void deleteProjectMember(ProjectMember.Pk pk);

    void updateProjectMember(ProjectMember projectMember);
}
