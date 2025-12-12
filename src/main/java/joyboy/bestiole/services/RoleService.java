package joyboy.bestiole.services;

import joyboy.bestiole.entities.Role;
import joyboy.bestiole.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repo;

    public Role create(Role r) {
        r.setId(null);
        return repo.save(r);
    }

    public Role update(Role r) {
        return repo.save(r);
    }

    public List<Role> findAll() {
        return repo.findAll();
    }

    public Role findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
