package ru.findfood.PersonalArea.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@EqualsAndHashCode
@Schema(description = "Модель цели пользователя с точки зрения веса")
public class GoalDto {

    @Schema(description = "Описание цели пользования сервисом")
    private String title;

    @Schema(description = "Коэффициент необходимого потребления белков", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer protein;

    @Schema(description = "Коэффициент необходимого потребления жиров", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer fat;

    @Schema(description = "Коэффициент необходимого потребления углеводов", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer carbohydrate;

    @Schema(description = "Необходимое количество каллорий", requiredMode = Schema.RequiredMode.AUTO)
    private Integer calories;

    public GoalDto() {
    }

    public GoalDto(String title, Integer protein, Integer fat, Integer carbohydrate, Integer calories) {
        this.title = title;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Integer carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}

