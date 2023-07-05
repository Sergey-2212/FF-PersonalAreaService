package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "t_title")
    private String title;

    @Column(name = "t_protein")
    private Float protein;

    @Column(name = "t_fat")
    private Float fat;

    @Column(name = "t_carbohydrate")
    private Float carbohydrate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Person> persons;
}
