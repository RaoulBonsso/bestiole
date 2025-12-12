package joyboy.bestiole.services;

import joyboy.bestiole.entities.Person;
import joyboy.bestiole.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public Person create(Person p) {
        p.setId(null);
        return repo.save(p);
    }

    public Person update(Person p) {
        return repo.save(p);
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Page<Person> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
