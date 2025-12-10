package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findByAgeGreaterThanEqual(Integer age);


}
