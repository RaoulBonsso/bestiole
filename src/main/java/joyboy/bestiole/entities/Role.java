package joyboy.bestiole.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    @ManyToMany(mappedBy = "roles")
    private List<Person> persons = new ArrayList<>();

    @Override
    public String toString() {
        return "Role { id=" + id +
                ", label='" + label + '\'' +
                " }";
    }


}
