package joyboy.bestiole.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
@Getter
@Setter
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "common_name", nullable = false)
    private String commonName;

    @Column(name = "latin_name", nullable = false)
    private String latinName;

    @OneToMany(mappedBy = "species")
    private List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        return "Species { id=" + id +
                ", commonName='" + commonName + '\'' +
                ", latinName='" + latinName + '\'' +
                " }";
    }
}
