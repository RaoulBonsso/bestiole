package joyboy.bestiole.services;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repo;

    public Animal create(Animal a) {
        a.setId(null);
        return repo.save(a);
    }

    public Animal update(Animal a) {
        return repo.save(a);
    }

    public List<Animal> findAll() {
        return repo.findAll();
    }

    public Animal findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
