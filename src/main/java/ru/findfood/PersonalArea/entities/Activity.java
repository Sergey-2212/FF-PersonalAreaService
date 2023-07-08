package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.findfood.PersonalArea.enums.ActivityTitle;

import java.util.List;

@Entity
@Table(name = "activity")
@NoArgsConstructor
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "t_title")
    private ActivityTitle title;
    @Column(name = "t_coefficient")
    private Float coefficient;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<Person> persons;

    public Activity(Long id, ActivityTitle title, Float coefficient) {
        this.id = id;
        this.title = title;
        this.coefficient = coefficient;
    }
}
