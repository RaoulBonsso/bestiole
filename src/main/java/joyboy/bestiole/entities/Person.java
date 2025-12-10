package joyboy.bestiole.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String login;

    private String mdp;
    @Column(name = "active" ,columnDefinition = "TINYINT")
    private Boolean active;


    @ManyToMany
    @JoinTable(name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "person_animals",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "animals_id"))
    private List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        return "Person { id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", active=" + active +
                " }";
    }
}
