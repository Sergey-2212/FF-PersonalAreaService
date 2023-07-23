package ru.findfood.PersonalArea.dtos;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель цели пользователя с точки зрения веса")
public class GoalDto {

    @Schema(description = "id перечисления в БД", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Schema(description = "Описание цели пользования сервисом")
    private String title;

    @Schema(description = "Коэффициент необходимого потребления белков", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer protein;

    @Schema(description = "Коэффициент необходимого потребления жиров", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer fat;

    @Schema(description = "Коэффициент необходимого потребления углеводов", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer carbohydrate;

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
}

