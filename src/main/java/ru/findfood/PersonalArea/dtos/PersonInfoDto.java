package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Schema(description = "Модель расширенной анкеты пользователя")
public class PersonInfoDto {

    @Schema(description = "Id расширенной акеты ползователя")
    private Long id;

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
    public PersonInfoDto() {
    }

    public PersonInfoDto(Long id, String city, String street, String house, Short apartment, Integer index, String phoneNumber, String email) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PersonInfoDto dto)) return false;

        return new EqualsBuilder().append(getId(), dto.getId()).append(getCity(), dto.getCity()).append(getStreet(), dto.getStreet()).append(getHouse(), dto.getHouse()).append(getApartment(), dto.getApartment()).append(getIndex(), dto.getIndex()).append(getPhoneNumber(), dto.getPhoneNumber()).append(getEmail(), dto.getEmail()).append(getTelegramName(), dto.getTelegramName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getCity()).append(getStreet()).append(getHouse()).append(getApartment()).append(getIndex()).append(getPhoneNumber()).append(getEmail()).append(getTelegramName()).toHashCode();
    }
}
