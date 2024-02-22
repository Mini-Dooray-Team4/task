package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.repository.TagRepository;
import com.nhnacademy.project.task.service.TagService;
import com.nhnacademy.project.task.entity.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository repository;

    @Override
    public List<Tag> getAllTags() {
        return repository.findAll();
    }

    @Override
    public Tag getTag(Integer tagId) {
        return repository.findById(tagId).orElse(null);
    }

    @Override
    public void createTag(Tag tag) {
        repository.save(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        repository.deleteById(tagId);
    }

    @Override
    public void updateTag(Tag tag) {
        if (repository.existsById(tag.getTagId())) {
            repository.save(tag);
        }
    }
}