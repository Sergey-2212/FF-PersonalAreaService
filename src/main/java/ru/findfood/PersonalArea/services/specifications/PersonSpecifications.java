package ru.findfood.PersonalArea.services.specifications;


import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;


import java.util.Collection;
import java.util.Locale;

public class PersonSpecifications {
    public static Specification<Person> usernameLike(String partUsername){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("username")), String.format("%%%s%%", partUsername.toLowerCase(Locale.ROOT)));
    }
    public static Specification<Person> emailLike(String partEmail){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("personInfo").get("email"), String.format("%%%s%%", partEmail));
    }
    public static Specification<Person> lastnameLike(String partLastname){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("personInfo").get("lastname")), String.format("%%%s%%", partLastname.toLowerCase(Locale.ROOT)));
    }
    public static Specification<Person> getByEmailFromEmailList(Collection<String> emailList){
        return (root, criteriaQuery, criteriaBuilder) -> {
            criteriaBuilder.createQuery().distinct(true);
            Join<Person, PersonInfo> joinPersonPersonInfo = root.join("personInfo", JoinType.LEFT);
            return joinPersonPersonInfo.get("email").in(emailList);
        };
    }
}
