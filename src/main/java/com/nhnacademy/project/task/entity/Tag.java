package com.nhnacademy.project.task.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name")
    @Length(min = 1, max = 20)
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}