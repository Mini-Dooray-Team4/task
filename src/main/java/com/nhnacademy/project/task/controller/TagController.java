package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.service.TagService;
import com.nhnacademy.project.task.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService service;

    @GetMapping()
    public List<Tag> getAllTags() {
        return service.getAllTags();
    }

    @GetMapping("/{tagId}")
    public Tag getTag(@PathVariable Integer tagId) {
        return service.getTag(tagId);
    }

    @PostMapping()
    public void createTag( @RequestBody Tag tag) {
        service.createTag(tag);
    }

    @PutMapping("/{tagId}")
    public void updateTag(@PathVariable Integer tagId, @RequestBody Tag tag) {
        service.updateTag(tag);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Integer tagId) {
        service.deleteTag(tagId);
    }
}