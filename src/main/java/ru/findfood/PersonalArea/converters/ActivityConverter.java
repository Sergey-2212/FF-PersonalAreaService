package ru.findfood.PersonalArea.converters;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.ActivityDto;
import ru.findfood.PersonalArea.entities.Activity;

@Component
@NoArgsConstructor
public class ActivityConverter {

    public ActivityDto entityToDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setId(activity.getId());
        activityDto.setTitle(activity.getTitle());
        activityDto.setCoefficient(activity.getCoefficient());
        return activityDto;

    }

    public Activity dtoToEntity(ActivityDto dto) {
        Activity activity = new Activity();
        activity.setId(dto.getId());
        activity.setTitle(dto.getTitle());
        activity.setCoefficient(dto.getCoefficient());
        return activity;
    }
}
