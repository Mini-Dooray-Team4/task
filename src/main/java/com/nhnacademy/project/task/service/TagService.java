package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
    Tag getTag(Integer tagId);
    void createTag(Tag tag);
    void deleteTag(Integer tagId);

    void updateTag(Tag tag);
}
