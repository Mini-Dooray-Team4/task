package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;
import com.nhnacademy.project.task.entity.MileStone;
import com.nhnacademy.project.task.entity.Project;
import com.nhnacademy.project.task.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class CommentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void getAllByTask_TaskIdAndProject_ProjectId() {
        Project project = new Project(null, "gahyoung", "projectName", "test중");
        MileStone milestone = new MileStone(null, "mile", LocalDateTime.now(), LocalDateTime.now(), project);
        Task task = new Task(null, project, "gahyoung", "title", "task", milestone, LocalDateTime.now());
        Comment comment1 = new Comment(null, "gahyoung", project, task, "안녕하세요", LocalDateTime.now());
        Comment comment2 = new Comment(null, "gahyoung2", project, task, "안녕하세요", LocalDateTime.now());

        testEntityManager.persistAndFlush(project);
        testEntityManager.persistAndFlush(milestone);
        testEntityManager.persistAndFlush(task);
        testEntityManager.persistAndFlush(comment1);
        testEntityManager.persistAndFlush(comment2);

        List<CommentDto> comments = commentRepository.getAllByTask_TaskIdAndProject_ProjectId(task.getTaskId(), project.getProjectId());

        assertThat(comments.get(0).getContent()).isEqualTo("안녕하세요");
        assertThat(comments.size()).isEqualTo(2);
    }

    @Test
    void getByCommentIdAndTask_TaskIdAndProject_ProjectId() {
        Project project = new Project(null, "gahyoung", "projectName", "test중");
        MileStone milestone = new MileStone(null, "mile", LocalDateTime.now(), LocalDateTime.now(), project);
        Task task = new Task(null, project, "gahyoung", "title", "task", milestone, LocalDateTime.now());
        Comment comment3 = new Comment(null, "gahyoung98", project, task, "content1", LocalDateTime.now());

        testEntityManager.persistAndFlush(project);
        testEntityManager.persistAndFlush(milestone);
        testEntityManager.persistAndFlush(task);
        testEntityManager.persistAndFlush(comment3);

        CommentDto commentDto = commentRepository.getByCommentIdAndTask_TaskIdAndProject_ProjectId(comment3.getCommentId(), task.getTaskId(), project.getProjectId()).orElse(null);

        assertThat(commentDto).isNotNull();
        assertThat(commentDto.getUserId()).isEqualTo("gahyoung98");
    }
}