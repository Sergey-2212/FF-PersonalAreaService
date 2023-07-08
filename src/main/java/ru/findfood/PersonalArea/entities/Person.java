package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.findfood.PersonalArea.enums.Sex;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "tblPerson")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prsId")
    private Long id;
    @NotNull
    @Column(name = "prsUsername")
    private String username;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "prsSex")
    private Sex sex;

    @NotNull
    @Column(name = "prsBirthdate")
    private Date birthdate;
    @NotNull
    @Column(name = "prsWeight")
    private Integer weight;
    @NotNull
    @Column(name = "prsHeight")
    private Integer height;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "prsActivity_id")
    private Activity activity;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "prsGoal_id")
    private Goal goal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prsInfo_id")
    private PersonInfo personInfo;

    @CreationTimestamp
    @Column(name = "prsCreated_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "prsUpdated_at")
    private LocalDateTime updatedAt;

    public Person(Long id, String username, Sex sex, Date birthdate, Integer weight, Integer height, Activity activity, Goal goal, PersonInfo personInfo) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
        this.goal = goal;
        this.personInfo = personInfo;
    }
}
