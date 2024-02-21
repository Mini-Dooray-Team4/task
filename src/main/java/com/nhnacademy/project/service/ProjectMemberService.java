package com.nhnacademy.project.service;

import entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getAllProjectMembers();
    ProjectMember getProjectMember(Integer projectMemberId);
    void createProjectMember(ProjectMember projectMember);
    void deleteProjectMember(Integer projectMemberId);

    void updateProjectMember(ProjectMember projectMember);
}
