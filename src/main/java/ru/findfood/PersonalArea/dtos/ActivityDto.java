package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Schema(description = "Модель уровня физической активности пользователя")
public class ActivityDto {

    @Schema(description = "id перечисления в БД", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Schema(description = "Характеристика уровня физической активности пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Коэффициент зависящий от уровня физической активности", requiredMode = Schema.RequiredMode.REQUIRED)
    private Float coefficient;

    public ActivityDto() {
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

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ActivityDto that)) return false;

        return new EqualsBuilder().append(getId(), that.getId()).append(getTitle(), that.getTitle()).append(getCoefficient(), that.getCoefficient()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getTitle()).append(getCoefficient()).toHashCode();
    }
}
