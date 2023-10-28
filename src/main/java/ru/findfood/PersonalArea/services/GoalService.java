package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.GoalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;

    public Goal getById(Long id) {
        return  goalRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Goal is not found by Id - " + id)
        );
    }

    public Goal getByTitle(String title) {
        return  goalRepository.findByTitle(title).orElseThrow(
                () -> new NotFoundException("Goal is not found by title - " + title)
        );
    }

    public List<String> getAllTitles() {
        return goalRepository.findAll().stream().map(s -> s.getTitle()).collect(Collectors.toList());
    }


}
