package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
@Schema(description = "Модель анкеты пользователя")
public class PersonDto {
    @Schema(description = "Id пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "username пользователя для авторизации в сервисе", requiredMode = Schema.RequiredMode.REQUIRED,maxLength = 255)
    private String username;
    @Schema(description = "Пол пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sex;
    @Schema(description = "Дата рождения", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date birthdate;
    @Schema(description = "Вес пользователя в килограммах", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer weight;
    @Schema(description = "Рост пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer height;
    @Schema(description = "Уровень физической нагрузки", requiredMode = Schema.RequiredMode.REQUIRED)
    private String activity_title;
    @Schema(description = "Цель ползователя с точки зрения его веса", requiredMode = Schema.RequiredMode.REQUIRED)
    private String goal_title;
    @Schema(description = "Расширенная анкета пользователя")
    private PersonInfoDto info_dto;

  public PersonDto() {
    }

    public PersonDto(Long id, String username, String sex, Date birthdate, Integer weight, Integer height, String activity_title, String goal_title, PersonInfoDto info_dto) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.weight = weight;
        this.height = height;
        this.activity_title = activity_title;
        this.goal_title = goal_title;
        this.info_dto = info_dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getGoal_title() {
        return goal_title;
    }

    public void setGoal_title(String goal_title) {
        this.goal_title = goal_title;
    }

    public PersonInfoDto getInfo_dto() {
        return info_dto;
    }

    public void PersonInfoDto(PersonInfoDto infoDto) {
        this.info_dto = infoDto;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", weight=" + weight +
                ", height=" + height +
                ", activity_title=" + activity_title +
                ", goal_title=" + goal_title +
                ", info_id=" + info_dto +
                '}';
    }
}
