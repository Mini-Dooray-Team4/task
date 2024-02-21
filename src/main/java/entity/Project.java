package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "projects")
@Entity
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}
