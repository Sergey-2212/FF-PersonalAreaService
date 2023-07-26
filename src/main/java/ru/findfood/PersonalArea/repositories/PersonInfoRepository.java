package ru.findfood.PersonalArea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.findfood.PersonalArea.entities.PersonInfo;

import java.util.Optional;
@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo,Long> {

    @Override
    Optional<PersonInfo> findById(Long id);

    Optional<PersonInfo> findByTelegramName(String telegramName);

}
