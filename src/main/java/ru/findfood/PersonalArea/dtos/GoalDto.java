package ru.findfood.PersonalArea.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Schema(description = "Модель цели пользователя с точки зрения веса")
public class GoalDto {

    @Schema(description = "Описание цели пользования сервисом")
    private String title;

    @Schema(description = "Коэффициент необходимого потребления белков", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer proteins;

    @Schema(description = "Коэффициент необходимого потребления жиров", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer fats;

    @Schema(description = "Коэффициент необходимого потребления углеводов", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer carbohydrates;

    @Schema(description = "Необходимое количество каллорий", requiredMode = Schema.RequiredMode.AUTO)
    private Integer calories;

    @Schema(description = "Количествоприемов пищи в день", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer timesToEat;

    public GoalDto() {
    }

    public GoalDto(String title, Integer proteins, Integer fats, Integer carbohydrates, Integer calories) {
        this.title = title;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getTimesToEat() {
        return timesToEat;
    }

    public void setTimesToEat(Integer timesToEat) {
        this.timesToEat = timesToEat;
    }
}

