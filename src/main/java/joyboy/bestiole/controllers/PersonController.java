package joyboy.bestiole.controllers;

import joyboy.bestiole.entities.Person;
import joyboy.bestiole.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Person create(@RequestBody Person p) {
        if (p.getId() != null)
            throw new RuntimeException("ID must be null for creation");
        return service.create(p);
    }

    @PutMapping
    public Person update( @RequestBody Person p) {
        if (p.getId() == null)
            throw new RuntimeException("ID is required for update");
        return service.update(p);
    }

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    // Pagination
    @GetMapping("/page")
    public Page<Person> getPage(Pageable pageable) {
        return service.findPage(pageable);
    }
}
