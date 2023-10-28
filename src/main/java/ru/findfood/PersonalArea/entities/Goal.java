package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
@Table(name = "pl_goal")
public class Goal {
    private final static int CALORIES_IN_PROTEIN = 4;
    private final static int CALORIES_IN_FAT = 9;
    private final static int CALORIES_IN_CARBOHYDRATE = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @Column(name = "goal_title")
    private String title;

    @Column(name = "goal_protein")
    private Integer proteins;

    @Column(name = "goal_fat")
    private Integer fats;

    @Column(name = "goal_carbohydrate")
    private Integer carbohydrates;

    @OneToMany(mappedBy = "goal")
    @ToString.Exclude
    private List<Person> persons;

    @Column(name = "times_to_eat")
    private Integer timesToEat;

    public Goal(String title, Integer proteins, Integer fats, Integer carbohydrates) {
        this.title = title;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Integer getCalories() {
        return proteins * CALORIES_IN_PROTEIN +
                fats * CALORIES_IN_FAT +
                carbohydrates * CALORIES_IN_CARBOHYDRATE;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Goal goal = (Goal) o;
        return id != null && Objects.equals(id, goal.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
