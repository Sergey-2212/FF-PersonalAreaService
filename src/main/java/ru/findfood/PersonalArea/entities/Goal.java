package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "plGoal")
public class Goal {
    private final static int CALORIES_IN_PROTEIN = 4;
    private final static int CALORIES_IN_FAT = 9;
    private final static int CALORIES_IN_CARBOHYDRATE = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goalId")
    private Long id;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "goalTitle")
//    private GoalTitle title;

    @Column(name = "goalTitle")
    private String title;

    @Column(name = "goalProtein")
    private Integer protein;

    @Column(name = "goalFat")
    private Integer fat;

    @Column(name = "goalCarbohydrate")
    private Integer carbohydrate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Person> persons;

    @Column(name = "timesTo_Eat")
    private Integer timesToEat;

    public Goal(Long id, String title, Integer protein, Integer fat, Integer carbohydrate) {
        this.id = id;
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public int getCalories() {
        return protein * CALORIES_IN_PROTEIN +
                fat * CALORIES_IN_FAT +
                carbohydrate * CALORIES_IN_CARBOHYDRATE;
    }
}
