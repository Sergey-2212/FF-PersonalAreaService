package ru.findfood.PersonalArea.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblAddress")
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

    @NotNull
    @Column(name = "infCity")
    private String city;

    @NotNull
    @Column(name = "infStreet")
    private String street;

    @NotNull
    @Column(name = "infHouse")
    private String house;

    @Column(name = "infApartment")
    private Short apartment;


    @Column(name = "infIndex")
    private Integer index;

    @NotNull
    @Column(name = "infPhoneNumber")
    private String phoneNumber;

    @Column(name = "infEmail")
    private String email;

    public PersonInfo(Long id, Person person, String city, String street, String house, Short apartment, Integer index, String phoneNumber, String email) {
        this.id = id;
        this.person = person;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
