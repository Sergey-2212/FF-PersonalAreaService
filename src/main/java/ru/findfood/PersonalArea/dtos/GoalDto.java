package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Модель цели пользователя с точки зрения веса")
public class GoalDto {

    @Schema(description = "id перечисления в БД", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Schema(description = "Описание цели пользования сервисом")
    private String title;

    @Schema(description = "Коэффициент необходимого потребления белков", requiredMode = Schema.RequiredMode.REQUIRED)
    private Float protein;

    @Schema(description = "Коэффициент необходимого потребления жиров", requiredMode = Schema.RequiredMode.REQUIRED)
    private Float fat;

    @Schema(description = "Коэффициент необходимого потребления углеводов", requiredMode = Schema.RequiredMode.REQUIRED)
    private Float carbohydrate;

    public GoalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
