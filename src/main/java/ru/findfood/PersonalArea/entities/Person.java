package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person person)) return false;

        return new EqualsBuilder().append(getId(), person.getId()).append(getUsername(), person.getUsername()).append(getPersonInfo(), person.getPersonInfo()).append(getSex(), person.getSex()).append(getBirthdate(), person.getBirthdate()).append(getWeight(), person.getWeight()).append(getHeight(), person.getHeight()).append(getActivity(), person.getActivity()).append(getGoal(), person.getGoal()).append(getCreatedAt(), person.getCreatedAt()).append(getUpdatedAt(), person.getUpdatedAt()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getUsername()).append(getPersonInfo()).append(getSex()).append(getBirthdate()).append(getWeight()).append(getHeight()).append(getActivity()).append(getGoal()).append(getCreatedAt()).append(getUpdatedAt()).toHashCode();
    }
}
