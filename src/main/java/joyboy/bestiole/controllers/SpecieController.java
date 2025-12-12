package joyboy.bestiole.controllers;

import joyboy.bestiole.entities.Species;
import joyboy.bestiole.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpecieController {

    @Autowired
    private SpeciesService service;

    @PostMapping
    public Species create( @RequestBody Species s) {
        if (s.getId() != null)
            throw new RuntimeException("ID must be null for creation");
        return service.create(s);
    }

    @PutMapping
    public Species update(@RequestBody Species s) {
        if (s.getId() == null)
            throw new RuntimeException("ID is required for update");
        return service.update(s);
    }

    @GetMapping
    public List<Species> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Species findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
