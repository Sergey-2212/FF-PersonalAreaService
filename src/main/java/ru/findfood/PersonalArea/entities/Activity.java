package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "pl_activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long id;

    @Column(name = "act_title")
    private String title;
    @Column(name = "act_coefficient")
    private Float coefficient;

    @OneToMany(mappedBy = "activity")
    @ToString.Exclude
    private List<Person> persons;

    public Activity(Long id, String title, Float coefficient) {
        this.id = id;
        this.title = title;
        this.coefficient = coefficient;
    }

    public Activity(String title, Float coefficient) {
        this.title = title;
        this.coefficient = coefficient;
    }

}
