package com.nhnacademy.project.task.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Project_members")
public class ProjectMember {

    @EmbeddedId
    private Pk pk;

    @MapsId("projectId")
    @ManyToOne
    @NotBlank
    @JoinColumn(name = "project_id")
    private Project project;

    @Length(min = 3, max = 20)
    @Column(name = "user_id")
    String userId;

    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable{
        private Integer projectId;
    }
}