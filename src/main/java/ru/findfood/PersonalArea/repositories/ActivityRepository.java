package ru.findfood.PersonalArea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.enums.ActivityTitle;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Optional<Activity> findByTitle(String activity_title);
}
