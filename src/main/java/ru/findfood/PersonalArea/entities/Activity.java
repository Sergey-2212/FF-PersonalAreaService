package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pl_activity")
@NoArgsConstructor
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long id;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "actTitle")
//    private ActivityTitle title;

    @Column(name = "act_title")
    private String title;
    @Column(name = "act_coefficient")
    private Float coefficient;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
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
