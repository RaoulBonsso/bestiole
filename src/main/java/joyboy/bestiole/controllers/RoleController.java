package joyboy.bestiole.controllers;

import joyboy.bestiole.entities.Role;
import joyboy.bestiole.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    public Role create(@RequestBody Role r) {
        if (r.getId() != null)
            throw new RuntimeException("ID must be null for creation");
        return service.create(r);
    }

    @PutMapping
    public Role update(@RequestBody Role r) {
        if (r.getId() == null)
            throw new RuntimeException("ID is required for update");
        return service.update(r);
    }

    @GetMapping
    public List<Role> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
