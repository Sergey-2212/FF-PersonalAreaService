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
    private final static int CALORIES_IN_PROTEIN = 4;
    private final static int CALORIES_IN_FAT = 9;
    private final static int CALORIES_IN_CARBOHYDRATE = 4;

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
    private Integer protein;

    @Column(name = "goal_fat")
    private Integer fat;

    @Column(name = "goal_carbohydrate")
    private Integer carbohydrate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Person> persons;

    @Column(name = "times_to_eat")
    private Integer timesToEat;

    public Goal(String title, Integer protein, Integer fat, Integer carbohydrate) {
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public Integer getCalories() {
        return protein * CALORIES_IN_PROTEIN +
                fat * CALORIES_IN_FAT +
                carbohydrate * CALORIES_IN_CARBOHYDRATE;

    }
}
