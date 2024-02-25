package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.TagRegisterDto;
import com.nhnacademy.project.task.domain.TaskDto;
import com.nhnacademy.project.task.domain.TaskRegisterDto;
import com.nhnacademy.project.task.domain.TaskResponseDto;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Tag;
import com.nhnacademy.project.task.repository.ProjectRepository;
import com.nhnacademy.project.task.repository.TagRepository;
import com.nhnacademy.project.task.repository.TaskRepository;
import com.nhnacademy.project.task.service.TaskService;
import com.nhnacademy.project.task.entity.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service("taskService")
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;

    @Override
    public List<TaskDto> getAllTasks() {
        return repository.getAllBy();
    }

    @Override
    public List<Task> getAllByProjectId(Integer projectId) {
        return repository.getAllByProject_ProjectId(projectId);
    }

    @Override
    public TaskResponseDto getTask(Integer taskId) {
        return repository.getByTaskId(taskId).orElse(null);
    }

    @Override
    public void createTask(TaskRegisterDto taskRegisterDto) {
        log.info("{}", taskRegisterDto);
        Task task = new Task();
        BeanUtils.copyProperties(taskRegisterDto, task);
        task.setCreateAt(LocalDateTime.now());
        task.setTaskContent("");
        Project project = new Project();
        project.setProjectId(taskRegisterDto.getProjectId());
        task.setProject(project);
        repository.save(task);
    }

    @Override
    public void createTag(TagRegisterDto tagRegisterDto) {
        Tag tag = new Tag();
        Project project = projectRepository.findById(tagRegisterDto.getProjectId()).orElse(null);
        tag.setProject(project);


        tag.setTagId(null);
        tag.setTagName(tagRegisterDto.getTagName());

        log.info("{}",tag);

        tagRepository.save(tag);
    }

    @Override
    public void deleteTask(Integer taskId) {
        if (repository.existsById(taskId))
            repository.deleteById(taskId);
    }

    @Override
    public void updateTask(TaskRegisterDto registerDto) {
        Task task = new Task();
        BeanUtils.copyProperties(registerDto, task);

        task.setCreateAt(LocalDateTime.now());

        if (repository.existsById(task.getTaskId()))
            repository.save(task);
    }
}
