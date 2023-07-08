package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.enums.Sex;

import java.util.Date;
@Schema(description = "Модель анкеты пользователя")
public class PersonDto {
    @Schema(description = "Id пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "username пользователя для авторизации в сервисе", requiredMode = Schema.RequiredMode.REQUIRED,maxLength = 255)
    private String username;
    @Schema(description = "Пол пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Sex sex;
    @Schema(description = "Дата рождения", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date birthdate;
    @Schema(description = "Вес пользователя в килограммах", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer weight;
    @Schema(description = "Рост пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer height;
    @Schema(description = "Уровень физической нагрузки", requiredMode = Schema.RequiredMode.REQUIRED)
    private Activity activity_title;
    @Schema(description = "Цель ползователя с точки зрения его веса", requiredMode = Schema.RequiredMode.REQUIRED)
    private Goal goal_title;
    @Schema(description = "Id расширенной анкеты пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long Info_id;

  public PersonDto() {
    }

    public PersonDto(Long id, String username, Sex sex, Date birthdate, Integer weight, Integer height, Activity activity_title, Goal goal_title, Long info_id) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.weight = weight;
        this.height = height;
        this.activity_title = activity_title;
        this.goal_title = goal_title;
        Info_id = info_id;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
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

    public Activity getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(Activity activity_title) {
        this.activity_title = activity_title;
    }

    public Goal getGoal_title() {
        return goal_title;
    }

    public void setGoal_title(Goal goal_title) {
        this.goal_title = goal_title;
    }

    public Long getInfo_id() {
        return Info_id;
    }

    public void setInfo_id(Long info_id) {
        Info_id = info_id;
    }

}
