package joyboy.bestiole.controllers;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @PostMapping
    public Animal create(@RequestBody Animal a) {
        if (a.getId() != null)
            throw new RuntimeException("ID must be null for creation");
        return service.create(a);
    }

    @PutMapping
    public Animal update(@RequestBody Animal a) {
        if (a.getId() == null)
            throw new RuntimeException("ID is required for update");
        return service.update(a);
    }

    @GetMapping
    public List<Animal> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
