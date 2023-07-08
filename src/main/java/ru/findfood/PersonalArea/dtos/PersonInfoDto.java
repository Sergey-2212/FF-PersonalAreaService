package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель расширенной анкеты пользователя")
public class PersonInfoDto {

    @Schema(description = "Id расширенной акеты ползователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Id основной анкеты пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long personId;

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

    public PersonInfoDto() {
    }

    public PersonInfoDto(Long id, Long personId, String city, String street, String house, Short apartment, Integer index, String phoneNumber, String email) {
        this.id = id;
        this.personId = personId;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
}
