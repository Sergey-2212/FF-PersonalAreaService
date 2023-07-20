package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.findfood.PersonalArea.enums.Sex;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tbl_person")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prs_id")
    private Long id;
    //@NotNull
    @Column(name = "prs_username")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prs_person_info_id")
    private PersonInfo personInfo;
    //@NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "prs_sex")
    private Sex sex;

    //@NotNull
    @Column(name = "prs_birthdate")
    private LocalDate birthdate;

    //@NotNull
    @Column(name = "prs_weight")
    private Integer weight;

    //@NotNull
    @Column(name = "prs_height")
    private Integer height;

    //@NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prs_activity_id")
    private Activity activity;

    //@NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prs_goal_id")
    private Goal goal;

    @CreationTimestamp
    @Column(name = "prs_created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "prs_updated_at")
    private LocalDateTime updatedAt;


}
