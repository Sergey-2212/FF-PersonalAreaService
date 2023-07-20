package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pl_goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "goalTitle")
//    private GoalTitle title;

    @Column(name = "goal_title")
    private String title;

    @Column(name = "goal_protein")
    private Float protein;

    @Column(name = "goal_fat")
    private Float fat;

    @Column(name = "goal_carbohydrate")
    private Float carbohydrate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Person> persons;

    public Goal(Long id, String title, Float protein, Float fat, Float carbohydrate) {
        this.id = id;
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public Goal(String title, Float protein, Float fat, Float carbohydrate) {
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }
}
