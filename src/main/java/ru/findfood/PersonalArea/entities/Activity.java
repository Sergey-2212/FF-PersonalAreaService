package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "activity")
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "t_title")
    private String title;

    @Column(name = "t_coefficient")
    private Float coefficient;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<Person> persons;
}
