package com.nhnacademy.project.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task_tags")
public class TaskTag {

    @EmbeddedId
    private Pk pk;

    @MapsId("taskId")
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @MapsId("tagId")
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable{
        private Integer taskId;
        private Integer tagId;
    }
}