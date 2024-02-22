package com.nhnacademy.project.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}