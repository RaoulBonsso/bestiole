package joyboy.bestiole.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @ManyToMany(mappedBy = "animals")
    private List<Person> persons = new ArrayList<>();

    @Override
    public String toString() {
        return "Animal { id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", sex='" + sex + '\'' +

                " }";
    }
}
