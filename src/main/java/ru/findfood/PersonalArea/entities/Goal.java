package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.findfood.PersonalArea.enums.GoalTitle;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "plGoal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goalId")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "goalTitle")
    private GoalTitle title;

    @Column(name = "goalProtein")
    private Float protein;

    @Column(name = "goalFat")
    private Float fat;

    @Column(name = "goalCarbohydrate")
    private Float carbohydrate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Person> persons;

    public Goal(Long id, GoalTitle title, Float protein, Float fat, Float carbohydrate) {
        this.id = id;
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }
}
