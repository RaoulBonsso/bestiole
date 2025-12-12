package joyboy.bestiole.services;

import joyboy.bestiole.entities.Species;
import joyboy.bestiole.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository repo;

    public Species create(Species s) {
        s.setId(null);
        return repo.save(s);
    }

    public Species update(Species s) {
        return repo.save(s);
    }

    public List<Species> findAll() {
        return repo.findAll();
    }

    public Species findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
