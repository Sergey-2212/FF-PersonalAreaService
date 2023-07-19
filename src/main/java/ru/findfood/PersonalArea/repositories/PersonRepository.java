package ru.findfood.PersonalArea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByUsername(String username);
    Optional<Person> findPersonById(Long id);

    Optional<Person> findByPersonInfo(PersonInfo info);
}
