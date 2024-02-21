package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_id")
    private Integer mileStoneId;

    @Column(name = "milestone_name")
    private String mileStoneName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}