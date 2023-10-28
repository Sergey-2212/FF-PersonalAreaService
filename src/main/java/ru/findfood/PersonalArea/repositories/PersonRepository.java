package ru.findfood.PersonalArea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    Optional<Person> findPersonByUsername(String username);
    Optional<Person> findPersonById(Long id);

    void deletePersonByUsername(String username);
    Optional<Person> findByPersonInfo(PersonInfo info);
}
