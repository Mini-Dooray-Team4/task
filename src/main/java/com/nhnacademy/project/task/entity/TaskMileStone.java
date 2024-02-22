package com.nhnacademy.project.task.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task_milestone")
public class TaskMileStone {
    @EmbeddedId
    private Pk pk;

    @MapsId("tagId")
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @MapsId("mileStoneId")
    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private MileStone mileStone;

    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable{
        private Integer tagId;
        private Integer mileStoneId;
    }
}