package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Schema(description = "Модель расширенной анкеты пользователя")
public class PersonInfoDto {

    @Schema(description = "Id расширенной акеты ползователя")
    private Long id;

    @Schema(description = "Имя пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Иван")
    private String firstname;

    @Schema(description = "Отчество пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Иванович")
    private String surname;

    @Schema(description = "Фамилия пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Иванов")
    private String lastname;

    @Schema(description = "Город", requiredMode = Schema.RequiredMode.NOT_REQUIRED, maxLength = 255)
    private String city;

    @Schema(description = "Улица", requiredMode = Schema.RequiredMode.NOT_REQUIRED, maxLength = 255)
    private String street;

    @Schema(description = "Номер дома", requiredMode = Schema.RequiredMode.NOT_REQUIRED, maxLength = 50, example = "5/1")
    private String house;

    @Schema(description = "Номер квартиры", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Short apartment;

    @Schema(description = "Почтовый индекс", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer index;

    @Schema(description = "Номер телефона", requiredMode = Schema.RequiredMode.NOT_REQUIRED, maxLength = 20)
    private String phoneNumber;

    @Schema(description = "Электронная почта", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;

    @Schema(description = "Имя пользователя в Telegram", requiredMode = Schema.RequiredMode.NOT_REQUIRED, pattern = "@.{5,32}")
    private String telegramName;

    @CreationTimestamp
    @Column(name = "prs_created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "prs_updated_at")
    private LocalDateTime updatedAt;

    public PersonInfoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Short getApartment() {
        return apartment;
    }

    public void setApartment(Short apartment) {
        this.apartment = apartment;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegramName() {
        return telegramName;
    }

    public void setTelegramName(String telegramName) {
        this.telegramName = telegramName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "PersonInfoDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment=" + apartment +
                ", index=" + index +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}

