package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblPersonalInfo")
@Data
@NoArgsConstructor
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "infId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "infPerson_id")
    private Person person;


    @Column(name = "infCity")
    private String city;


    @Column(name = "infStreet")
    private String street;


    @Column(name = "infHouse")
    private String house;

    @Column(name = "infApartment")
    private Short apartment;


    @Column(name = "infIndex")
    private Integer index;


    @Column(name = "infPhoneNumber")
    private String phoneNumber;

    @Column(name = "infEmail")
    private String email;

    @Column(name = "infTelegram_name")
    private String telegramName;

    public PersonInfo(Long id, Person person, String city, String street, String house, Short apartment, Integer index, String phoneNumber, String email, String telegramName) {
        this.id = id;
        this.person = person;
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
