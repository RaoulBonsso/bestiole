package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :min AND :max")
    List<Person> findByAgeBetween(@Param("min") int min, @Param("max") int max);

    @Query("SELECT p FROM Person p WHERE :animal MEMBER OF p.animals")
    List<Person> findPersonsWhoOwn(@Param("animal") Animal animal);


}
