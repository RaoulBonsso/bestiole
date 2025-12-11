package joyboy.bestiole.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import joyboy.bestiole.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void deletePersonsWithoutAnimals() {

        List<Person> persons = em.createQuery("""
                SELECT p FROM Person p
                WHERE p.animals IS EMPTY
                """, Person.class).getResultList();

        for (Person p : persons) {
            em.remove(em.contains(p) ? p : em.merge(p));
        }
    }


    @Override
    public void generateRandomPersons(int count) {

        for (int i = 0; i < count; i++) {

            Person p = new Person();
            p.setFirstname("User" + i);
            p.setLastname("Random" + i);
            p.setAge((int)(Math.random() * 70) + 10);
            p.setLogin("user" + i);
            p.setMdp("pass" + i);
            p.setActive(true);

            em.persist(p);
        }
    }
}
