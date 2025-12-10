package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  /*  List<Animal> findByName(String name);

    List<Animal> findByColor(String color);

    List<Animal> findBySex(String sex);

    List<Animal> findBySpeciesId(Integer speciesId);

   */
  List<Animal> findBySpecies(Species species);
  List<Animal> findByColorIn(List<String> colors);


}
