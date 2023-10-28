package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_person_info")
@Data
@NoArgsConstructor
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inf_id")
    private Long id;

    @OneToOne(mappedBy = "personInfo")
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "inf_city")
    private String city;

    @Column(name = "inf_street")
    private String street;


    @Column(name = "inf_house")
    private String house;

    @Column(name = "inf_apartment")
    private Short apartment;

    @Column(name = "inf_index")
    private Integer index;

    @Column(name = "inf_phone_number")
    private String phoneNumber;

    @Column(name = "inf_email")
    private String email;

    @Column(name = "inf_telegram_name")
    private String telegramName;

    @CreationTimestamp
    @Column(name = "prs_created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "prs_updated_at")
    private LocalDateTime updatedAt;

    public PersonInfo(Long id, Person person, String firstname, String surname, String lastname, String city, String street, String house, Short apartment, Integer index, String phoneNumber, String email, String telegramName) {
        this.id = id;
        this.person = person;
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.telegramName = telegramName;
    }
}
